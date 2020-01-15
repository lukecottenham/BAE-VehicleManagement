package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.exceptions.UserNotFoundException;
import com.bae.persistence.domain.User;
import com.bae.persistence.domain.Vehicle;
import com.bae.persistence.repo.UserRepo;

@Service
public class UserService {
	
	private UserRepo repo;
	
	private VehicleService vehicleService;
	
	@Autowired
	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	public User addNewUser(User userToAdd) {
		return repo.save(userToAdd);
	}
	
	public User findUserById(Long id) {
		return this.repo.findById(id).orElseThrow(() -> new UserNotFoundException());
	}
	
	public User updateUser(User user, Long id) {
		User toUpdate = findUserById(id);
		toUpdate.setFirstName(user.getFirstName());
		return this.repo.save(toUpdate);
	}
	
	public User addVehicleToUser(Long id, Vehicle vehicle) {
		User toUpdate = findUserById(id);
		Vehicle newVehicle = this.vehicleService.addNewVehicle(vehicle);
		toUpdate.getVehicles().add(newVehicle);
		return this.repo.saveAndFlush(toUpdate);
	}
	
	public String deleteUser(Long primaryKeyOfUsers) {
		repo.deleteById(primaryKeyOfUsers);
		return "User successfully removed";
	}
}
