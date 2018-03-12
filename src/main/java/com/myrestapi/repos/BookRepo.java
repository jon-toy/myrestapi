package com.myrestapi.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myrestapi.objects.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer>
{
	public Book findById(int id);
}
