package com.amazing.library.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazing.library.books.model.Book;
import com.amazing.library.books.repository.BookRepository;

@RestController
public class BookController 
{
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping(value="/getBooks")
	public List<Book> getBooks()
	{
		return bookRepository.findAll();
	}
	
	@GetMapping(value="/getBooksAvailableForIssue")
	public List<Book> getBooksAvailableForIssue()
	{
		List<Book> books = bookRepository.findAll();
		List<Book> availableBooks = new ArrayList<>();
		if(books != null && !books.isEmpty())
		{
			for (Book book : books) 
			{
				if(book.getTotalCopies()-book.getIssuedCopies() > 0)
				{
					availableBooks.add(book);
				}
			}
		}
		return availableBooks;
	}
	
	@GetMapping(value="/getBook")
	public Book getBook(
			@RequestParam(value = "isbn") int isbn)
	{
		return bookRepository.findByIsbn(isbn);
	}
	
	@GetMapping(value="/isBookAvailableForIssue")
	public boolean isBookAvailableForIssue(
			@RequestParam(value = "isbn") int isbn)
	{
		Book book = bookRepository.findByIsbn(isbn);
		
		if(book != null && 
				book.getTotalCopies()-book.getIssuedCopies() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@PostMapping(value="/addBook")
	public Book addBook(
			@RequestBody(required = true) Book book)
	{
		return bookRepository.save(book);
	}
	@PostMapping(value = "/deleteBook")
	public void deleteBook(
			@RequestParam(value = "isbn") int isbn)
	{
		bookRepository.deleteByIsbn(isbn);
	}
	
	@PutMapping(value = "/updateBook")
	public Book updateBook(
			@RequestBody(required = true) Book book)
	{
		return bookRepository.save(book);
	}
}
