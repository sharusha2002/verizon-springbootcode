package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	ArrayList<User> listOfUsers = new ArrayList<>(
			Arrays.asList(
					new User(10, "sharusha", "Chennai"),
					new User(15, "Meha", "Coimbatore"),
					new User(20, "Sandhiya", "Thiruvannamalai")));
	
	@RequestMapping("/users")
	ArrayList<User> getAllUsers(){
		return listOfUsers;
	}
	
	@RequestMapping("/users/{userid}")
	User getUserById(@PathVariable Integer userid) {
		User user = listOfUsers
				.stream()
				.filter(ref -> ref.userid().equals(userid))
				.findFirst()
				.get();
		return user;
	}
	
}
