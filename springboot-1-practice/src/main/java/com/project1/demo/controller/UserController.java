package com.project1.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.demo.dto.User;
import com.project1.demo.service.UserService;


@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService service;	
	@GetMapping("/users")
	ArrayList<User> getUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/users/{userid}")
	public User getUserById(@PathVariable Integer userid) {
		return service.getUserById(userid);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		service.addNewUser(user);
	}
	
	@PutMapping("/users/{userid}")
	public void updateUser(@PathVariable Integer userid, @RequestBody User user) {
		service.updateUser(userid, user);
	}
	
	@DeleteMapping("/users/{userid}")
	public void deleteUser(@PathVariable Integer userid) {
		service.deleteUser(userid);
	}
}
