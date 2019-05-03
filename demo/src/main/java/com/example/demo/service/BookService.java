package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	public Books save(Books book)
	{
		return bookRepository.save(book);
	}
}
