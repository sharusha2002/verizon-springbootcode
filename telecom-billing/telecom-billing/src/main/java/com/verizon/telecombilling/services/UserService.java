package com.verizon.telecombilling.services;

import com.verizon.telecombilling.entities.User;


public interface UserService {

	public String signUp(User user);
	public Iterable<User> getAllUsers();
	public String signIn(String userMail , String password);
}
