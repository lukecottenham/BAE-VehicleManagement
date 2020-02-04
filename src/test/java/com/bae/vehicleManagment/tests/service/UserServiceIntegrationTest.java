package com.bae.vehicleManagment.tests.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.User;
import com.bae.persistence.repo.UserRepo;
import com.bae.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

	

		@Autowired
		private UserService service;

		@Autowired
		private UserRepo repo;

		private User newUser;

		private User testUserWithID;

		@Before
		public void init() {
			this.newUser = new User(null, "Jim", "McIvor", "Test@test.com", "M57", "admin");
			
			this.repo.deleteAll();

			this.testUserWithID = this.repo.save(this.newUser);
		}
		
		@Test
		public void testCreateUser() {
			assertEquals(this.testUserWithID, this.service.addNewUser(newUser));
		}

		@Test
		public void testDeleteUser() {
			assertThat(this.service.deleteUser(this.testUserWithID.getId()));
		}

		@Test
		public void testFindUserByID() {
			assertThat(this.service.findUserById(this.testUserWithID.getId())).isEqualTo(this.testUserWithID);
		}

		@Test
		public void testReadUsers() {
			List<User> users = new ArrayList<>();
			users.add( this.testUserWithID);
		
			assertThat(this.service.getAllUsers()).isEqualTo(users);
		}

		@Test
		public void testUpdateUser() {
			User newUser = new User(null, "Liam", "McIvor", "Test@test.com", "M57", "admin");
			User updatedUser = new User(newUser.getId(), newUser.getFirstName(), newUser.getSurname(), newUser.getEmail(), newUser.getPostcode(), newUser.getPassword());
			updatedUser.setId(this.testUserWithID.getId());
			
			assertThat(this.service.updateUser(newUser, this.testUserWithID.getId())).isEqualTo(updatedUser);
		}

	
}
