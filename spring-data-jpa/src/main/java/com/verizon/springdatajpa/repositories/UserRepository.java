package com.verizon.springdatajpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.springdatajpa.entities.User;

import jakarta.persistence.NamedNativeQueries;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	List<User> findByName(String name);
	
	List<User> findByLocation(String location);
	
	}
