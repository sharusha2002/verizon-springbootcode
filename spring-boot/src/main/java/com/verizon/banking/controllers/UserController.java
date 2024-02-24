package com.verizon.banking.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.banking.entities.User;
import com.verizon.banking.services.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/users")
	public Iterable<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Integer id) {
		return service.getUserById(id);
	}

	@PostMapping("/user")
	public void addNewUser(@RequestBody User user) {
		service.addNewUser(user);
	}

	@PostMapping("/user/{email}/{password}")
	public String signin(@PathVariable String email, @PathVariable String password) {
	    return service.signIn(email, password);
	}

	@GetMapping("/user/balance/{id}")
	public String getBalance(@PathVariable Integer id) {
		return service.getBalanceById(id);
	}

}
