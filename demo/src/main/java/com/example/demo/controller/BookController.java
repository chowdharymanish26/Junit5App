package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addNewBook(@RequestBody Books book)
	{
		bookService.save(book);
	}
}
