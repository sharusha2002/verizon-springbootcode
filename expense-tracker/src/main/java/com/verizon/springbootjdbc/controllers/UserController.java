package com.verizon.springbootjdbc.controllers;

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

import com.verizon.springbootjdbc.entities.User;
import com.verizon.springbootjdbc.services.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	UserService service;
	
		
	@GetMapping("/users")
	public Iterable<User> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/user/{userid}")
	public Optional<User> getUserById(@PathVariable Integer userid){
		Optional<User> getUserById = service.getUserById(userid);
		return service.getUserById(userid);
	}
	

	
	@PostMapping("/user/{userid}")
	public void addNewUser(@RequestBody User user) {
		service.addNewUser(user);
	}
	
	@PutMapping("/user/{userid}")
	public void updateExistingUser(@PathVariable Integer userid, @RequestBody User user) {
		service.updateExistingUser(userid, user);
	}
	
	@DeleteMapping("/user/{userid}")
	public void deleteExistingUserById(@PathVariable Integer userid) {
		service.deleteExistingUserById(userid);
	}

}
