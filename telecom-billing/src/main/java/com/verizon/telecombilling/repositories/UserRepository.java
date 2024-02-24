package com.verizon.telecombilling.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.verizon.telecombilling.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
 
	public Optional<User> findByUserMail(String userMail);
}
