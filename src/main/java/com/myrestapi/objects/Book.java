package com.myrestapi.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book 
{
	@Id
	private int id;
	
	private String title;
	private String author;
	private Genre genre;
	
	public Book()
	{
		 
	}
	
	public Book(String title, String author, Genre genre, int id)
	{
		this.title = title;
		this.author = author;
		this.id = id;
		this.genre = genre;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public String getAuthor() 
	{
		return author;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public Genre getGenre()
	{
		return genre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public void setGenre(Genre genre) 
	{
		this.genre = genre;
	}
	
	
}
