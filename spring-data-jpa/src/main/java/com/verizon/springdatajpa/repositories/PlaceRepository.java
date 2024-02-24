
package com.verizon.springdatajpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.springdatajpa.entities.Place;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

	public List<Place> findByUserId(Integer userid);

	
}


