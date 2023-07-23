package com.amazing.library.books.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazing.library.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{

	@Transactional
	public Book findByIsbn(int isbn);
	
	@Transactional
	public void deleteByIsbn(int isbn);
}
