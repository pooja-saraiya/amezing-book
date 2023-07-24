package com.amazing.library.issue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookIssueController 
{
	@Autowired
	private BookIssueRepository bookIssueRepository;
	
	private RestTemplate restTemplate;
	
	@PostMapping("/issueBook")
	private boolean issueBook(
			@RequestParam(name="bookId") int bookId,
			@RequestParam(name="username") String userName)
	{
		
		ResponseEntity<Book> responseEntity = restTemplate
	                .getForEntity("http://localhost:8082/books/isBookAvailableForIssue/"+bookId  ,
	                Book.class);
		
		Book book = responseEntity.getBody();
		if(book != null)
		{
			BookIssue bookIssue = bookIssueRepository.findByBookIdAnduserIdAndStatus(bookId,userName,1);
			if(bookIssue != null )
			{

				bookIssue.setStatus(0);
				bookIssueRepository.save(bookIssue);

				book.setIssuedCopies(book.getIssuedCopies() +1);
				book.setAvailableCopies(book.getAvailableCopies()-1);
				MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
				headers.add("Content-Type", "application/json");
				HttpEntity<Book> requestUpdate = new HttpEntity<>(book,headers);
				restTemplate.exchange("http://localhost:8082/books/updateBook", HttpMethod.PUT, requestUpdate, Book.class);
				return true;

			}

			else
			{
				bookIssue = new BookIssue();
				bookIssue.setBookId(bookId);
				bookIssue.setUserId(userName);
				bookIssue.setStatus(0);
				bookIssueRepository.save(bookIssue);
				return true;

			}
		}
		return false;
	}
	
	@PostMapping("/returnBook")
	private boolean returnBook(
			@RequestParam(name="bookId") int bookId,
			@RequestParam(name="username") String userName)
	{
		BookIssue bookIssue = bookIssueRepository.findByBookIdAnduserIdAndStatus(bookId,userName,0);
		if(bookIssue != null )
		{
			if(bookIssue.getStatus() == 0)
			{
				bookIssue.setStatus(1);
				bookIssueRepository.save(bookIssue);
				
				ResponseEntity<Book> responseEntity = restTemplate
		                .getForEntity("http://localhost:8082/books/getBook/"+bookId  ,
		                Book.class);
				Book book = responseEntity.getBody();
				if(book != null)
				{
					book.setIssuedCopies(book.getIssuedCopies() -1);
					book.setAvailableCopies(book.getAvailableCopies()+1);
					MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			        headers.add("Content-Type", "application/json");
			        HttpEntity<Book> requestUpdate = new HttpEntity<>(book,headers);
			        restTemplate.exchange("http://localhost:8082/books/updateBook", HttpMethod.PUT, requestUpdate, Book.class);
					return true;
				}
				
			}
			
		}
		return false;
	}
	
	@GetMapping("/fetchAllIssuedBooks")
	private List<BookIssue> fetchAllIssuedBooks()
	{
		return bookIssueRepository.findAllByStatus(0);
	}
	
	@GetMapping("/fetchAllBooksIssuedtoUser")
	private List<BookIssue> fetchAllBooksIssuedtoUser(
			@RequestParam(name="username") String userName)
	{
		return bookIssueRepository.findByuserIdAndStatus(userName,0);
	}
	
	@GetMapping("/fetchAllIssuesForBook")
	private List<BookIssue> fetchAllIssuesForBook(
			@RequestParam(name="bookId") int bookId)
	{
		return bookIssueRepository.fetchAllIssuesForBookAndStatus(bookId,0);
	}
	
}
