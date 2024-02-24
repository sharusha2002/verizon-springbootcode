package com.customer.support.services;

import com.customer.support.entities.User;

public interface UserService {

    String signUp(User user);

    Iterable<User> getAllUsers();

	User findByUserId(Integer loggedInUserId);

	void save(User user);

//    User login(String userMail, String password, User user);
}
