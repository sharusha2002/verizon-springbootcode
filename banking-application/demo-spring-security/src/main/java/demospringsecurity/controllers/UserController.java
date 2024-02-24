package demospringsecurity.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demospringsecurity.entities.User;
import demospringsecurity.services.MyUserDetails;
import demospringsecurity.services.MyUserDetailsService;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	MyUserDetailsService services;
	
	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to the dashboard";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "Welcome user....";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Welcome admin";
	}
	
	@GetMapping("/users")
	public Iterable<User> getAllUsers() {
		return services.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	Optional<User> getUserById(@PathVariable Integer id){
		return services.getUserById(id);
	}

}
