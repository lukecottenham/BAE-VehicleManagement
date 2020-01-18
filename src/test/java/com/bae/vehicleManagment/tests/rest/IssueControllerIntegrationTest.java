package com.bae.vehicleManagment.tests.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.persistence.domain.Issue;
import com.bae.persistence.repo.IssueRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IssueControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private IssueRepo repo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private Issue testIssue;

	private Issue testIssueWithID;

	@Before
	public void init() {
		this.repo.deleteAll();

		this.testIssue = new Issue(id, "Chain", "30", "12-12-2019");
		this.testIssueWithID = this.repo.save(this.testIssue);
		this.id = this.testIssueWithID.getId();
	}

//	@Test
//	public void testCreateIssue() throws Exception {
//		String result = this.mock
//				.perform(request(HttpMethod.POST, "/issue/createIssue").contentType(MediaType.APPLICATION_JSON)
//						.content(this.mapper.writeValueAsString(testIssue)).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		assertEquals(this.mapper.writeValueAsString(testIssueWithID), result);
//	}

	@Test
	public void testDeleteIssue() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/issue/" + this.id)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllIssues() throws Exception {
		List<Issue> issueList = new ArrayList<>();
		issueList.add(this.testIssueWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/issue").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(issueList), content);
	}

	@Test
	public void testUpdateIssue() throws Exception {
		Issue newIssue = new Issue(id, "Wheels", "7", "12-12-2019");
		Issue updatedIssue = new Issue(id, newIssue.getIssueName(), newIssue.getUrgency(), newIssue.getLastAddressed());
		updatedIssue.setId(this.id);

		String result = this.mock
				.perform(request(HttpMethod.PATCH, "/updateIssue/" + this.id).accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newIssue)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(updatedIssue), result);
	}

}