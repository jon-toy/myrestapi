package com.myrestapi.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myrestapi.objects.Book;
import com.myrestapi.objects.Genre;
import com.myrestapi.objects.Response;
import com.myrestapi.repos.BookRepo;

@RestController("/book")
public class BookController 
{
	static private Random RANDOM = new Random();
	
	@Autowired
	private BookRepo repo;
	
	@RequestMapping(value="/get")
	private Book getBook(@RequestParam(value="id", defaultValue="-1") int id)
	{
		return repo.findById(id);
	}
	
	@RequestMapping(value="/put")
	private Response getBook(@RequestParam(value="author", defaultValue="null") String author,
			@RequestParam(value="title", defaultValue="null") String title, @RequestParam(value="genre", defaultValue="null") String genre)
	{
		if ( author.equals("null") || title.equals("null") || genre.equals("null") )
		{
			return new Response("Missing parameter", false, null);
		}
		
		Genre genre_enum = Genre.valueOf(genre);
		
		if ( genre_enum == null )
		{
			return new Response("Invalid genre " + genre + ": Valid Genres: " + Genre.values(), false, null);
		}
		
		Book book = new Book(author, title, genre_enum, RANDOM.nextInt(1000));
		
		repo.save(book);
		
		return new Response("Saved Book", true, book);
	}
}
