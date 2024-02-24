package com.verizon.springbootjdbc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.springbootjdbc.entities.User;
import com.verizon.springbootjdbc.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	 
	
	public Iterable<User> getAllUsers(){
		return repository.findAll();
	}
	
	public Optional<User> getUserById(Integer userid) {
		return repository.findById(userid);
	}
	
	public void addNewUser(User user) {
		repository.save(user);
	}
	
	public void updateExistingUser(Integer userid, User newUser) {
	    Optional<User> existingUserOptional = repository.findById(userid);

	    if (existingUserOptional.isPresent()) {
	        User existingUser = existingUserOptional.get();
	        
	        // Set the new values for the existing user
	        existingUser.setName(newUser.getName());
	        existingUser.setEmail(newUser.getEmail());
	        existingUser.setPassword(newUser.getPassword());
	        repository.save(existingUser);
	    } else {
	        System.out.println("User not found");	    }
	}
	
	public void deleteExistingUserById(Integer userid) {
		repository.deleteById(userid);
	}

}
