package com.amazing.library.books.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="books")
public class Book 
{
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTital() {
		return tital;
	}

	public void setTital(String tital) {
		this.tital = tital;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public int getIssuedCopies() {
		return issuedCopies;
	}

	public void setIssuedCopies(int issuedCopies) {
		this.issuedCopies = issuedCopies;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@EmbeddedId
	@Column(name="isbn")
	private int isbn;
	
	@Column(name="tital")
	@NonNull
	private String tital;
	
	@Column(name="published_date")
	@NonNull
	private Date publishedDate;
	
	@Column(name="total_copies")
	@NonNull
	private int totalCopies;
	
	@Column(name="issued_copies")
	@NonNull
	private int issuedCopies;
	
	@Column(name="author")
	@NonNull
	private String author;
	
}
