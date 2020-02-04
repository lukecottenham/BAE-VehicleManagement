package com.bae.vehicleManagment.tests.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertFalse;
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

import com.bae.persistence.domain.User;
import com.bae.persistence.domain.Vehicle;
import com.bae.persistence.repo.UserRepo;
import com.bae.persistence.repo.VehicleRepo;
import com.bae.service.UserService;
import com.bae.service.VehicleService;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest {

	@InjectMocks
	private UserService service;
	
	@InjectMocks
	private VehicleService vService;

	@Mock
	private UserRepo repo;

	@Mock
	private VehicleRepo vRepo;
	
	private List<User> userList;

	private User testUser;
	
	private Vehicle testVehicle;

	private User testUserWithID;
	
	private Vehicle testVehicleWithID;

	final long id = 1L;
	


	@Test
	public void createUserTest() {
		when(this.repo.save(testUser)).thenReturn(testUserWithID);
		
		assertEquals(this.testUserWithID, this.service.addNewUser(testUser));

		verify(this.repo, times(1)).save(this.testUser);
	}
	
//	@Test
//	public void addVehicleToUserTest() {
//		User newUser = new User(id, "Jim", "McIvor", "Test@test.com", "M57", "admin");
//		when(this.repo.save(newUser)).thenReturn(newUser);
//		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testUserWithID));
//		
//		
//		this.service.addVehicleToUser(newUser.getId(), testVehicle);
//		
//
//		assertFalse(newUser.getVehicles().isEmpty());
//
//		verify(this.repo, times(1)).findById(1L);
////		verify(this.repo, times(1)).save(updatedUser);
//	}

	@Test
	public void deleteUserTest() {
		when(this.repo.existsById(id)).thenReturn(true, false);

		this.service.deleteUser(id);

		verify(this.repo, times(1)).deleteById(id);
//		verify(this.repo, times(2)).existsById(id);
	}

	@Test
	public void findUserByIDTest() {
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testUserWithID));

		assertEquals(this.testUserWithID, this.service.findUserById(this.id));

		verify(this.repo, times(1)).findById(this.id);
	}

	@Test
	public void readUsersTest() {

		when(repo.findAll()).thenReturn(this.userList);

		assertFalse("Controller has found no users", this.service.getAllUsers().isEmpty());

//		verify(repo, times(1)).findAll();
	}

	@Test
	public void updateUserTest() {
		User newUser = new User(id, "Jim", "McIvor", "Test@test.com", "M57", "admin");
		
		when(this.repo.findById(this.id)).thenReturn(Optional.of(this.testUserWithID));

		User updatedUser = new User(id, newUser.getFirstName(), newUser.getSurname(), newUser.getEmail(), newUser.getPostcode(), newUser.getPassword());
		updatedUser.setId(this.id);

		when(this.repo.save(updatedUser)).thenReturn(updatedUser);

		assertEquals(updatedUser, this.service.updateUser(newUser, this.id));

		verify(this.repo, times(1)).findById(1L);
		verify(this.repo, times(1)).save(updatedUser);
	}
	
	@Before
	public void init() {
		this.userList = new ArrayList<>();
		this.userList.add(testUser);
		this.testUser = new User(id, "Liam", "McIvor", "Test@test.com", "M57", "admin");
		
		this.testUserWithID = new User(id, testUser.getFirstName(), testUser.getSurname(), testUser.getEmail(), testUser.getPostcode(), testUser.getPassword());
		this.testUserWithID.setId(id);
		this.testVehicle = new Vehicle(1L, "Kawazaki", "Z1000", "10-10-2019", "10-10-2019", "10-10-2019");
		this.testVehicleWithID = new Vehicle(id, testVehicle.getMake(), testVehicle.getModel(), testVehicle.getTaxDate(), testVehicle.getMotDate(), testVehicle.getInsuranceDate());
		this.testVehicleWithID.setId(id);
	}

}