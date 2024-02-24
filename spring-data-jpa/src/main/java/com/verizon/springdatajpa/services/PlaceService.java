package com.verizon.springdatajpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.springdatajpa.entities.Place;
import com.verizon.springdatajpa.repositories.PlaceRepository;

@Service
public class PlaceService {
	
	@Autowired
	PlaceRepository repository;
	
	public List<Place> getAllPlacesByUserId(Integer userid) {
		return repository.findByUserId(userid);
	}
	
	public Optional<Place> getPlacesById(Integer id) {
		return repository.findById(id);
	}
	
	public Iterable<Place> getAllPlaces() {
		return repository.findAll();
	}
	
	public void addNewPlace(Place place) {
		repository.save(place);
	}
	
	public void updateExistingPlace(Place place) {
		repository.save(place);
	}
	
	public void deleteExistingPlace(Integer id) {
		repository.deleteById(id);
	}

}
