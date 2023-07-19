package com.amazing.library.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookIssueController 
{
	@Autowired
	private BookIssueRepository bookIssueRepository;
	@PostMapping("/issueBook")
	private boolean issueBook(
			@RequestParam(name="book_id") int id,
			@RequestParam(name="username") String userName)
	{
		BookIssue bookIssue = bookIssueRepository.findByBookIdAnduserId(id,userName);
		if(bookIssue != null )
		{
			if(bookIssue.getStatus() == 0)
					return false;
			else
			{
				bookIssue.setStatus(0);
				bookIssueRepository.save(bookIssue);
				return true;
			}
		}
		else
		{
			bookIssue = new BookIssue();
			bookIssue.setBookId(id);
			bookIssue.setUserId(userName);
			bookIssue.setStatus(0);
			bookIssueRepository.save(bookIssue);
			return true;
			
		}
	}
	
	@PostMapping("/returnBook")
	private boolean returnBook(
			@RequestParam(name="book_id") int id,
			@RequestParam(name="username") String userName)
	{
		BookIssue bookIssue = bookIssueRepository.findByBookIdAnduserId(id,userName);
		if(bookIssue != null )
		{
			if(bookIssue.getStatus() == 0)
			{
				bookIssue.setStatus(1);
				bookIssueRepository.save(bookIssue);
				return true;
			}
			
		}
		return false;
	}
}
