package com.bae.vehicleManagment.tests.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Issue;
import com.bae.persistence.domain.Vehicle;
import com.bae.persistence.repo.IssueRepo;
import com.bae.service.IssueService;

@RunWith(SpringRunner.class)
public class IssueServiceUnitTest {

	@InjectMocks
	private IssueService service;

	@Mock
	private IssueRepo repo;

	private List<Issue> issueList;

	private Issue testIssue;

	private Issue testIssueWithID;

	final long id = 1L;
	


	@Test
	public void createIssueTest() {
		when(this.repo.save(testIssue)).thenReturn(testIssueWithID);

		assertEquals(this.testIssueWithID, this.service.addNewIssue(testIssue));

		verify(this.repo, times(1)).save(this.testIssue);
	}

	@Test
	public void deleteIssueTest() {
		when(this.repo.existsById(id)).thenReturn(true, false);

		this.service.deleteIssue(id);

		verify(this.repo, times(1)).deleteById(id);
//		verify(this.repo, times(2)).existsById(id);
	}

	@Test
	public void findIssueByIDTest() {
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testIssueWithID));

		assertEquals(this.testIssueWithID, this.service.findIssueById(this.id));

		verify(this.repo, times(1)).findById(this.id);
	}

	@Test
	public void readIssuesTest() {

		when(repo.findAll()).thenReturn(this.issueList);

		assertFalse("Controller has found no issues", this.service.getAllIssues().isEmpty());

		verify(repo, times(1)).findAll();
	}

	@Test
	public void updateIssuesTest() {
		Issue newIssue = new Issue(id, "Oil", "", "12-2-2019");
		
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testIssueWithID));

		Issue updatedIssue = new Issue(id, newIssue.getIssueName(), newIssue.getUrgency(), newIssue.getLastAddressed());
		updatedIssue.setId(this.id);

		when(this.repo.save(updatedIssue)).thenReturn(updatedIssue);

		assertEquals(updatedIssue, this.service.updateIssue(newIssue, this.id));

		verify(this.repo, times(1)).findById(1L);
		verify(this.repo, times(1)).save(updatedIssue);
	}
	
	@Before
	public void init() {
		this.issueList = new ArrayList<>();
		this.issueList.add(testIssue);
		this.testIssue = new Issue(id, "Chain", "60", "10-10-2017");
		this.testIssueWithID = new Issue(id, testIssue.getIssueName(), testIssue.getUrgency(), testIssue.getLastAddressed());
		this.testIssueWithID.setId(id);
	}

}