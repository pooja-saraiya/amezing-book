package com.amazing.library.issue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Integer> 
{
	public BookIssue findByBookIdAnduserIdAndStatus(int bookId, String userName,int status);

	public List<BookIssue> findByuserIdAndStatus(String userName,int status);

	public List<BookIssue> fetchAllIssuesForBookAndStatus(int bookId,int status);

	public List<BookIssue> findAllByStatus(int status);
}
