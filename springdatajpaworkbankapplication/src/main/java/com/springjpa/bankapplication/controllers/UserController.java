package com.springjpa.bankapplication.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.bankapplication.entities.User;
import com.springjpa.bankapplication.services.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/users")
	public String addNewUser(@RequestBody User user) {
		
		return service.addNewUser(user); 
	}
	
	@PostMapping("/users/email/password")
	public String sigiIn(@RequestBody Map<String,String> request) {
		String email=request.get("email");
		String password=request.get("password");
		return service.sigiIn(email, password);
			
	}
	
	@GetMapping("/users")
	public Iterable<User> allUsers() {
		return service.allUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Integer id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/users/balance/{id}")
	public String getBalanceById(@PathVariable Integer id) {
		return service.getBalanceById(id);
	}
	
}
