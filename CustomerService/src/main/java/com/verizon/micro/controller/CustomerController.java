package com.verizon.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.micro.entities.Customer;
import com.verizon.micro.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @GetMapping("/search")
    public List<Customer> searchCustomers(@PathVariable String name, @PathVariable(required = false) String subscription) {
        return customerRepository.findByNameContainingIgnoreCaseOrSubscriptionContainingIgnoreCase(name, subscription);
    }
    
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
}
