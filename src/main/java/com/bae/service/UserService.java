package com.bae.service;

import java.util.List;
import java.util.Optional;

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
	public UserService(UserRepo repo, VehicleService vehicleService) {
		this.repo = repo;
		this.vehicleService = vehicleService;
	}
	
	public List<User> getAllUsers() {
		repo.findAll();
		return repo.findAll();
	}
	
	public User addNewUser(User userToAdd) {
		return repo.save(userToAdd);
	}
	
	public User findUserById(Long id) {
		return this.repo.findById(id).orElseThrow(() -> new UserNotFoundException());
		
	}
	
//	public Optional<User> findUserByEmail( final String name) {
//			List list = getAllUsers();
//		    return list.stream().filter(o -> ((User) o).getEmail().equals(name)).findAny();
//		
//
//	}
	
	public User updateUser(User user, Long id) {
		User toUpdate = findUserById(id);
		toUpdate.setFirstName(user.getFirstName());
		return this.repo.save(toUpdate);
	}
	
	public User addVehicleToUser(Long id, Vehicle vehicle) {
		User toUpdate = findUserById(id);
		
		Vehicle newVehicle = this.vehicleService.addNewVehicle(vehicle);
		System.out.println(vehicle);
		toUpdate.getVehicles().add(newVehicle);
		return this.repo.save(toUpdate);
	}
	
	public String deleteUser(Long primaryKeyOfUsers) {
		repo.deleteById(primaryKeyOfUsers);
		return "User successfully removed";
	}

	public Optional<User> findUserByEmail(String email) {
		List<User> list = getAllUsers();
	    return list.stream().filter(o -> ((User) o).getEmail().equals(email)).findAny();
	}
}
