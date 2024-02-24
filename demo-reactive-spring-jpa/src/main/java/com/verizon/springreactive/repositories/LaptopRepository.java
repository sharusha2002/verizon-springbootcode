package com.verizon.springreactive.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.springreactive.entities.Laptop;

@Repository
public interface LaptopRepository extends ReactiveCrudRepository<Laptop, Integer>{

}
