package com.verizon.springbootjdbc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.springbootjdbc.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
User findByMobileNo(String mobileno);

}


