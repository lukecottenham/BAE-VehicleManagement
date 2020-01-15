package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.exceptions.IssueNotFoundException;
import com.bae.exceptions.VehicleNotFoundException;
import com.bae.persistence.domain.Issue;
import com.bae.persistence.domain.Vehicle;
import com.bae.persistence.repo.IssueRepo;

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
	
	public Issue findIssueById(Long id) {
		return this.repo.findById(id).orElseThrow(() -> new IssueNotFoundException());
	}
	
	public Issue updateIssue(Issue issue, Long id) {
		Issue toUpdate = findIssueById(id);
		toUpdate.setIssueName(issue.getIssueName());
		toUpdate.setUrgency(issue.getUrgency());
		toUpdate.setLastAddressed(issue.getLastAddressed());
		return this.repo.save(toUpdate);
	}
	
	public String deleteIssue(Long primaryKeyOfIssue) {
		repo.deleteById(primaryKeyOfIssue);
		return "Issue successfully removed";
	}
}
