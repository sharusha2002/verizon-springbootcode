package com.verizon.micro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.micro.repositories.ServiceRepository;
import com.verizon.micro.services.ServiceService;

@RestController
@RequestMapping("/services")
public class ServiceController {
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    @GetMapping
    public Iterable<com.verizon.micro.entities.Service> getAllServices() {
        return serviceRepository.findAll();
    }
    
    @GetMapping("/{serviceName}")
    public ResponseEntity<com.verizon.micro.entities.Service> getServiceByName(@PathVariable String serviceName) {
        Optional<com.verizon.micro.entities.Service> service = serviceRepository.findByServiceName(serviceName);
        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service createdService = serviceRepository.save(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdService);
    }
}
