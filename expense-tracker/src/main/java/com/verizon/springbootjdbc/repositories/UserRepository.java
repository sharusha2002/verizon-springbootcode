package com.verizon.springbootjdbc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.springbootjdbc.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	Optional<User> findByUserId(Integer userid);
}
