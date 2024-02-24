package com.customer.support.services;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.support.entities.User;
import com.customer.support.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public String signUp(User newUser) {
        Optional<User> user = repository.findByUserMail(newUser.getUserMail());
        if(user.isPresent()) {
            return "user mail already registered";
        } else {
            repository.save(newUser);
            return "user registration successful";
        }
    }
    
    @Override
    public User findByUserId(Integer userId) {
        return repository.findById(userId).orElse(null);
    }


    @Override
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

	@Override
	public void save(User user) {
		repository.save(user);
		
	}
        
 }