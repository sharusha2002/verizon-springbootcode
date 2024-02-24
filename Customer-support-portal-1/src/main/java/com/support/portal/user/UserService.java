package com.support.portal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.support.portal.user.security.JwtUtil;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	User saveUser(User user) {
		String encodedPassword= passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return repo.save(user);
	}
	
	public String login(UserCredentials credentials) {
		User user= repo.findByUsername(credentials.username());
		
		if(user==null) {
			throw new RuntimeException("User not found");
		}
		
		if(passwordEncoder.matches(credentials.password(), user.getPassword())) {
			String token= jwtUtil.generateToken(user.getUsername());
			return token;
		} else {
			throw new RuntimeException("Invalid password");
		}
	}
	

}
