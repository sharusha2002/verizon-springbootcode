package com.verizon.micro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.verizon.micro.entities.*;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    Optional<Service> findByServiceName(String serviceName);

	org.springframework.stereotype.Service save(org.springframework.stereotype.Service service);
}

