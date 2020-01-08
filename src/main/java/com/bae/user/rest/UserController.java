package com.bae.user.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bae.user.persistence.domain.User;
import com.bae.user.service.UserService;

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
	@PostMapping("/user")
	public User addUser(@RequestBody User userToAdd) {
		return service.addNewUser(userToAdd);
	}
	
	@CrossOrigin
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
}
