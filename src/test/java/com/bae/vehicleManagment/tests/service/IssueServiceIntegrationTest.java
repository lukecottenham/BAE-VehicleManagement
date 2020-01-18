package com.bae.vehicleManagment.tests.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Issue;
import com.bae.persistence.repo.IssueRepo;
import com.bae.service.IssueService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueServiceIntegrationTest {

	

		@Autowired
		private IssueService service;

		@Autowired
		private IssueRepo repo;

		private Issue testIssue;

		private Issue testIssueWithID;

		@Before
		public void init() {
			this.testIssue = new Issue(null, "Oil", "1", "10-10-2010");
			
			this.repo.deleteAll();

			this.testIssueWithID = this.repo.save(this.testIssue);
		}
		
		@Test
		public void testCreateIssue() {
			assertEquals(this.testIssueWithID, this.service.addNewIssue(testIssue));
		}

		@Test
		public void testDeleteIssue() {
			assertThat(this.service.deleteIssue(this.testIssueWithID.getId()));
		}

		@Test
		public void testFindIssueByID() {
			assertThat(this.service.findIssueById(this.testIssueWithID.getId())).isEqualTo(this.testIssueWithID);
		}

		@Test
		public void testReadIssues() {
			assertThat(this.service.getAllIssues()).isEqualTo(Arrays.asList(new Issue[] { this.testIssueWithID }));
		}

		@Test
		public void testUpdateIssue() {
			Issue newIssue = new Issue(null, "Chain", "7", "11-11-2-11");
			Issue updatedIssue = new Issue(newIssue.getId(), newIssue.getIssueName(), newIssue.getUrgency(), newIssue.getLastAddressed());
			updatedIssue.setId(this.testIssueWithID.getId());

			assertThat(this.service.updateIssue(newIssue, this.testIssueWithID.getId())).isEqualTo(updatedIssue);
		}

	
}
