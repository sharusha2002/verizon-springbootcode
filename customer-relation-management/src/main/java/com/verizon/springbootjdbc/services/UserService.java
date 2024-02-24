package com.verizon.springbootjdbc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.verizon.springbootjdbc.entities.User;
import com.verizon.springbootjdbc.repository.UserRepository;

@Repository
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public void createUser(User user) {
		repository.save(user);
	}
	
	public Optional<User> getUserById(Integer id) {
		return repository.findById(id);
	}
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}

}
