package com.bae.issue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.issue.persistence.domain.Issue;
import com.bae.issue.persistence.repo.IssueRepo;

@Service
public class IssueService {
	
	private IssueRepo repo;
	
	public IssueService(IssueRepo repo) {
		this.repo = repo;
	}
	
	public List<Issue> getAllIssues() {
		return repo.findAll();
	}
	
	public Issue addNewIssue(Issue issueToAdd) {
		return repo.save(issueToAdd);
	}
	
	public String deleteIssue(Long primaryKeyOfIssue) {
		repo.deleteById(primaryKeyOfIssue);
		return "Issue successfully removed";
	}
}
