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

import com.bae.persistence.domain.User;
import com.bae.rest.UserController;
import com.bae.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerUnitTest {

	@InjectMocks
	private UserController controller;

	@Mock
	private UserService service;

	private List<User> userList;

	private User testUser;

	private User testUserWithID;

	final long id = 1L;
	
	@Before
	public void init() {
		this.userList = new ArrayList<>();
		this.userList.add(testUser);
		this.testUser = new User(id, "Lim", "McIvor", "Test@test.com", "M57", "admin");
		this.testUserWithID = new User(id, testUser.getFirstName(), testUser.getSurname(), testUser.getEmail(), testUser.getPostcode(), testUser.getPassword());
		this.testUserWithID.setId(id);
	}

	@Test
	public void createUserTest() {
		when(this.service.addNewUser(testUser)).thenReturn(testUserWithID);

		assertEquals(this.testUserWithID, this.controller.addUser(testUser));

		verify(this.service, times(1)).addNewUser(this.testUser);
	}

	@Test
	public void deleteUserTest() {
		this.controller.deleteUser(id);

		verify(this.service, times(1)).deleteUser(id);
	}

	@Test
	public void findUserByIDTest() {
		when(this.service.findUserById(this.id)).thenReturn(this.testUserWithID);

		assertEquals(this.testUserWithID, this.controller.getUser(this.id));

		verify(this.service, times(1)).findUserById(this.id);
	}

	@Test
	public void getAllUsersTest() {

		when(service.getAllUsers()).thenReturn(this.userList);

		assertFalse("Controller has found no users", this.controller.getAllUsers().isEmpty());

		verify(service, times(1)).getAllUsers();
	}

	@Test
	public void updateUsersTest() {
		// given
		User newUser = new User(id, "Liam", "McIvor", "Test@test.com", "M57", "admin");
		User updatedUser = new User(id, newUser.getFirstName(), newUser.getSurname(), newUser.getEmail(), newUser.getPostcode(), newUser.getPassword());
		updatedUser.setId(this.id);

		when(this.service.updateUser(newUser, this.id)).thenReturn(updatedUser);

		assertEquals(updatedUser, this.controller.updateUser(this.id, newUser));

		verify(this.service, times(1)).updateUser(newUser, this.id);
	}

}