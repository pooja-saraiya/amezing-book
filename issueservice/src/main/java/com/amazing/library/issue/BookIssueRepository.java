package com.amazing.library.issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Integer> 
{
	public BookIssue findByBookIdAnduserId(int bookId, String userName);
}
