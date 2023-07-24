package com.amazing.library.issue;

import java.time.LocalDate;

public class Book
{
	private Integer isbn;
	private String title;
	private LocalDate publishedDate;
	private Integer totalCopies;
	private Integer issuedCopies;
	private Integer availableCopies;
	private String author;
	
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Integer getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}
	public Integer getIssuedCopies() {
		return issuedCopies;
	}
	public void setIssuedCopies(Integer issuedCopies) {
		this.issuedCopies = issuedCopies;
	}
	public Integer getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
