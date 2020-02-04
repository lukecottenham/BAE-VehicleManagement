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

import com.bae.persistence.domain.User;
import com.bae.persistence.repo.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private UserRepo repo;

	private ObjectMapper mapper = new ObjectMapper();

	private long id;

	private User testUser;

	private User testUserWithID;

	@Before
	public void init() {
		this.repo.deleteAll();

		this.testUser = new User(id, "Liam", "McIvor", "Test@test.com", "M57", "admin");
		this.testUserWithID = this.repo.save(this.testUser);
		this.id = this.testUserWithID.getId();
	}

	@Test
	public void testCreateUser() throws Exception {
		String result = this.mock
				.perform(request(HttpMethod.POST, "/user").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(testUser)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		testUserWithID.setId(testUserWithID.getId()+1);
		assertEquals(this.mapper.writeValueAsString(testUserWithID), result);
	}

	@Test
	public void testDeleteUser() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/user/" + this.id)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllUsers() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(this.testUserWithID);

		String content = this.mock.perform(request(HttpMethod.GET, "/user").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertEquals(this.mapper.writeValueAsString(userList), content);
	}

//	@Test
//	public void testUpdateUser() throws Exception {
//		User newUser = new User(id, "Jim", "Jims", "Tes1t@test.com", "M57", "admin");
//		User updatedUser = new User(id, newUser.getFirstName(), newUser.getSurname(), newUser.getEmail(), newUser.getPostcode(), newUser.getPassword());
//		updatedUser.setId(this.id);
//
//		String result = this.mock
//				.perform(request(HttpMethod.PUT, "/updateUser/" + this.id).accept(MediaType.APPLICATION_JSON)
//						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newUser)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		
//		assertEquals(this.mapper.writeValueAsString(updatedUser), result);
//	}

}