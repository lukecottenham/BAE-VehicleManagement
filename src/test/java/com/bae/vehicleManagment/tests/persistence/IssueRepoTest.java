package com.bae.vehicleManagment.tests.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Issue;
import com.bae.persistence.repo.IssueRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueRepoTest {

	@Autowired
	private IssueRepo repo;

	private final String TEST_NAME = "Oil";

	private final Issue TEST_ISSUE = new Issue();

	private Issue testSavedIssue;

	@Before
	public void init() {
		this.repo.deleteAll();
		this.testSavedIssue = this.repo.save(this.TEST_ISSUE);
	}

	@Test
	public void testFindByName() {
		assertThat(this.repo.findByIssueName(this.TEST_NAME)).isIn(this.testSavedIssue);
	}

}