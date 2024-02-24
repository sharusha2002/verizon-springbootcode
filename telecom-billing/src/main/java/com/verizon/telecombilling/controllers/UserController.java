package com.verizon.telecombilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.telecombilling.entities.User;
import com.verizon.telecombilling.services.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping("users/all")
	public Iterable<User> getAllUsers() {
		return service.getAllUsers() ;
	}
	
	@PostMapping("user/signup")
	public void signUp(User user) {
		service.signUp(user);
	}
}
