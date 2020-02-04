package com.bae.vehicleManagment.tests.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bae.persistence.domain.Issue;
import com.bae.rest.IssueController;
import com.bae.service.IssueService;

@RunWith(MockitoJUnitRunner.class)
public class IssueControllerUnitTest {

	@InjectMocks
	private IssueController controller;

	@Mock
	private IssueService service;

	private List<Issue> issueList;

	private Issue testIssue;

	private Issue testIssueWithID;

	final long id = 1L;
	
	@Before
	public void init() {
		this.issueList = new ArrayList<>();
		this.issueList.add(testIssue);
		this.testIssue = new Issue(id, "Chain", "30", "12-12-2019");
		this.testIssueWithID = new Issue(id, testIssue.getIssueName(), testIssue.getUrgency(), testIssue.getLastAddressed());
		this.testIssueWithID.setId(id);
	}

//	@Test
//	public void createIssueTest() {
//		when(this.service.addNewIssue(testIssue)).thenReturn(testIssueWithID);
//
//		assertEquals(this.testIssueWithID, this.controller.addIssue(testIssue));
//
//		verify(this.service, times(1)).addNewIssue(this.testIssue);
//	}

	@Test
	public void deleteIssueTest() {
		this.controller.deleteIssue(id);

		verify(this.service, times(1)).deleteIssue(id);
	}

	@Test
	public void findIsueByIDTest() {
		when(this.service.findIssueById(this.id)).thenReturn(this.testIssueWithID);

		assertEquals(this.testIssueWithID, this.controller.getIssue(this.id));

		verify(this.service, times(1)).findIssueById(this.id);
	}

	@Test
	public void getAllIssuesTest() {

		when(service.getAllIssues()).thenReturn(this.issueList);

		assertFalse("Controller has found no issues", this.controller.getAllIssues().isEmpty());

		verify(service, times(1)).getAllIssues();
	}

	@Test
	public void updateIssuesTest() {
		Issue newIssue = new Issue(id, "Oil Change", "1", "10-10-2019");
		Issue updatedIssue = new Issue(id, newIssue.getIssueName(), newIssue.getUrgency(), newIssue.getLastAddressed());
		updatedIssue.setId(this.id);

		when(this.service.updateIssue(newIssue, this.id)).thenReturn(updatedIssue);

		assertEquals(updatedIssue, this.controller.updateIssue(this.id, newIssue));

		verify(this.service, times(1)).updateIssue(newIssue, this.id);
	}

}