package com.verizon.springdatajpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.springdatajpa.entities.User;
import com.verizon.springdatajpa.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public Iterable<User> getAllUsers() {
				return repository.findAll();
	}
	
	public Optional<User> getUserById(Integer id) {
		return repository.findById(id);
	}
	
	public User createNewUser(User user) {
		return repository.save(user);
	}
	
	public void updateExistingUser(User user) {
		repository.save(user);
	}
	
	public void deleteExistingUser(Integer id) {
		repository.deleteById(id);
	}
	
	public List<User> getUserByName(String name){
		return repository.findByName(name);
	}
	
	public List<User> getUserByLocation(String location){
		return repository.findByLocation(location);
	}

}
