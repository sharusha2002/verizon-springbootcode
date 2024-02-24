package com.verizon.springbootjdbc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.springbootjdbc.entities.User;
import com.verizon.springbootjdbc.services.UserService;

@RestController
@RequestMapping("/mobile")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @GetMapping("/balance/{mobileNo}")
    public String getUserBalance(@PathVariable String mobileNo) {
        return service.getUserBalance(mobileNo);
    }
}

