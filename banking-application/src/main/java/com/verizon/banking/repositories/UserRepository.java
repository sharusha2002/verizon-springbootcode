package com.verizon.banking.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.banking.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByEmail(String email);
}
