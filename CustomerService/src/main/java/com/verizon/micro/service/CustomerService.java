package com.verizon.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.micro.entities.Customer;
import com.verizon.micro.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> searchCustomers(String name, String subscription) {
        if (name != null && subscription != null) {
            return customerRepository.findByNameContainingIgnoreCaseOrSubscriptionContainingIgnoreCase(name, subscription);
        } else if (name != null) {
            return customerRepository.findByNameContainingIgnoreCase(name);
        } else if (subscription != null) {
            return customerRepository.findBySubscriptionContainingIgnoreCase(subscription);
        } else {
            return getAllCustomers();
        }
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
