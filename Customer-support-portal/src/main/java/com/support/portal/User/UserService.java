package com.support.portal.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	public ResponseEntity<List<User>> getUserByEmail(String email) {
		List<User> users = userRepository.findByEmail(email);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}


	public ResponseEntity<User> createUser(User user) {
		User newUser = userRepository.save(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	public ResponseEntity<User> getUserById(Integer id) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<User> updateUser(Integer id, User user) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setConfirmpassword(user.getConfirmpassword());
			existingUser.setPhonenumber(user.getPhonenumber());
			User updatedUser = userRepository.save(existingUser);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Void> deleteUser(Integer id) {
		userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
