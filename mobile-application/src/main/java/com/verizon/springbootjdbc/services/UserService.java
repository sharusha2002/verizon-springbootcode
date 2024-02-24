package com.verizon.springbootjdbc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.springbootjdbc.entities.User;
import com.verizon.springbootjdbc.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository repository;
	
	
	public Optional<User> getUserById(Integer id) {
		return repository.findById(id);
	}
}
