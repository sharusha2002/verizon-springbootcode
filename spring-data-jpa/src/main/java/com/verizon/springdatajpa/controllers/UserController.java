package com.verizon.springdatajpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.springdatajpa.entities.User;
import com.verizon.springdatajpa.services.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/users")
	Iterable<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	Optional<User> getUserById(@PathVariable Integer id) {
		return service.getUserById(id);
		
	}
	
	@PostMapping("/user")
	public void createNewUser(@RequestBody User user) {
		service.createNewUser(user);
	}

	@PutMapping("/user/{id}")
	public void updateExisitingUser(@PathVariable Integer id, @RequestBody User user) {
		service.updateExistingUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteExistingUser(@PathVariable Integer id) {
		service.deleteExistingUser(id);
	}
	
	@GetMapping("/users/name/{name}")
	public List<User> getUserByName(@PathVariable String name){
		return service.getUserByName(name);
	}
	
	
	@GetMapping("/users/location/{location}")
	public List<User> getUserByLocation(@PathVariable String location){
		return service.getUserByLocation(location);
	}
}
