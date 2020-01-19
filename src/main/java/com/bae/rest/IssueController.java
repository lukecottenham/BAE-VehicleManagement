package com.bae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bae.persistence.domain.Issue;
import com.bae.persistence.domain.Vehicle;
import com.bae.service.IssueService;

@RestController
public class IssueController {

	private IssueService service;
	
	public IssueController(IssueService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping("/issue")
	public List<Issue> getAllIssues(){
		return service.getAllIssues();
	}
	
	@CrossOrigin
	@GetMapping("/getIssue/{id}")
	public Issue getIssue(@PathVariable Long id) {
		return this.service.findIssueById(id);
	}
	
//	@CrossOrigin
//	@PostMapping("/addIssue")
//	public Issue addIssue(@RequestBody Issue issueToAdd) {
//		return service.addNewIssue(issueToAdd);
//	}
	
	@CrossOrigin
	@PatchMapping("/updateIssue/{id}")
	public Issue updateIssue(@PathVariable Long id, @RequestBody Issue issue) {
		return this.service.updateIssue(issue, id);
	}
	
	@CrossOrigin
	@PatchMapping("/updateAddressed/{id}")
	public Issue updateIssueAddressed(@PathVariable Long id, @RequestBody Issue issue) {
		return this.service.updateIssueAddressed(issue, id);
	}
	
//	@CrossOrigin
//	@PatchMapping("/addIssue/{id}")
//	public Vehicle addIssueToVehicle(@PathVariable Long id, @RequestBody Issue issue) {
//		return this.service.addIssueToVehicle(id, issue);
//	}
	
	@CrossOrigin
	@DeleteMapping("/issue/{id}")
	public String deleteIssue(@PathVariable Long id) {
		return service.deleteIssue(id);
	}
}
