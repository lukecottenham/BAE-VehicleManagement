package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bae.persistence.domain.User;
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
	
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable Long id) {
		return this.service.findUserById(id);
	}
	
	@CrossOrigin
	@PostMapping("/user")
	public User addUser(@RequestBody User userToAdd) {
		return service.addNewUser(userToAdd);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@PathParam("id") Long id, @RequestBody User user) {
		return this.service.updateUser(user, id);
	}
	
	@CrossOrigin
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
}
