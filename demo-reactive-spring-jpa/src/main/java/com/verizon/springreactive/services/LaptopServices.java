package com.verizon.springreactive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.springreactive.entities.Laptop;
import com.verizon.springreactive.repositories.LaptopRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LaptopServices {
	
	@Autowired
	LaptopRepository repository;
	
	Mono<Laptop> getLaptopById(Integer id){
		return repository.findById(id);
	}

	Flux<Laptop> getAllLaptops(){
		return repository.findAll();
	}
}
