package com.amazing.library.issue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book_issues")
public class BookIssue 
{

	@Id
	@Column(name="book_issue_id")
	private int bookIssueId;
	
	@ManyToOne
	@JoinColumn(name = "isbn", table = "books")
	@Column(name="book_id")
	private int bookId;
	
	@ManyToOne
	@JoinColumn(name = "username", table = "user")
	@Column(name="user_id")
	private String userId;

	@Column(name="status")
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBookIssueId() {
		return bookIssueId;
	}

	public void setBookIssueId(int bookIssueId) {
		this.bookIssueId = bookIssueId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
