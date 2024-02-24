package com.verizon.micro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.verizon.micro.entities.*;

import com.verizon.micro.repositories.ServiceRepository;

@Service
public class ServiceService {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	
	public Service createService(Service service) {
		return serviceRepository.save(service);
	}
	
	public Optional<com.verizon.micro.entities.Service> getServiceByName(String name) {
		return serviceRepository.findByServiceName(name);
	}
	
	
	public Iterable<com.verizon.micro.entities.Service> getService() {
		return serviceRepository.findAll();
	}
}
