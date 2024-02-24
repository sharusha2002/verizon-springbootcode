package com.verizon.springbootjdbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.springbootjdbc.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
