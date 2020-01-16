package com.bae.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bae.persistence.domain.User;
import com.bae.persistence.domain.Vehicle;
import com.bae.service.UserService;

@RestController

public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@CrossOrigin
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable Long id) {
		return this.service.findUserById(id);
	}
	
	@CrossOrigin
	@PostMapping("/user")
	public User addUser(@RequestBody User userToAdd) {
		return service.addNewUser(userToAdd);
	}
	
	@CrossOrigin
	@PutMapping("/updateUser")
	public User updateUser(@PathParam("id") Long id, @RequestBody User user) {
		return this.service.updateUser(user, id);
	}
	
	@CrossOrigin
	@PatchMapping("/update/{id}")
	public User addVehicleToUser(@PathVariable Long id, @RequestBody Vehicle vehicle) {
		return this.service.addVehicleToUser(id, vehicle);
	}
	
	@CrossOrigin
	@GetMapping("/getEmail")
	public Optional<User> findByEmail(@PathVariable String email) {
		return this.service.findUserByEmail(email);
	}
	@CrossOrigin
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
}
