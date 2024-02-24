package com.verizon.banking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.banking.entities.User;
import com.verizon.banking.exceptions.SignUpException;
import com.verizon.banking.exceptions.UserNotFoundException;
import com.verizon.banking.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	// get all users
	public Iterable<User> getAllUsers() {

		return repository.findAll();
	}

	// get user by id
	public User getUserById(Integer id) {
		Optional<User> existingId = repository.findById(id);
		if (existingId.isPresent()) {
			return existingId.get();
		} else {
			throw new UserNotFoundException();
		}
	}

	// creating new user
	public String addNewUser(User user) {
		Optional<User> existingUser = repository.findByEmail(user.getEmail());
		if (existingUser.isPresent()) {
			throw new SignUpException();
		} else {
			repository.save(user);
			return "User registered successfully";
		}
	}

	// signin activity
	public String signIn(String email, String password) {
		Optional<User> existingUser = repository.findByEmail(email);
		if (existingUser.isPresent()) {
			if (existingUser.get().getPassword().equals(password)) {
				return "User signed in successfully";
			} else {
				throw new UserNotFoundException();
			}
		} else {
			throw new UserNotFoundException();
		}
	}

	// check bank balance
	public String getBalanceById(Integer id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			User balanceCheckingUser = user.get();
			return "Balance amount: " + balanceCheckingUser.getBalance();
		}
		throw new UserNotFoundException();
	}

}
