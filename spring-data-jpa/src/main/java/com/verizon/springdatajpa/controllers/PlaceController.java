package com.verizon.springdatajpa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.springdatajpa.entities.Place;
import com.verizon.springdatajpa.entities.User;
import com.verizon.springdatajpa.services.PlaceService;

@RestController
//@RequestMapping("api/v1")
public class PlaceController {
	
	@Autowired
	PlaceService service;
	
	@GetMapping("/api/v1/places/{userid}")
	public List<Place> getAllPlacesByUserId(Integer userid){
		return service.getAllPlacesByUserId(userid);
	}
	
	@GetMapping("/api/v1/places/{id}")
	public Optional<Place> getPlacesById(Integer id) {
		return service.getPlacesById(id);
	}
	
	@GetMapping("/api/v1/places")
	public Iterable<Place> getAllPlaces() {
		return service.getAllPlaces();
	}
	
	
	@PostMapping("/api/v1/place/{id}")
	public void addNewlace(@PathVariable Integer id, @RequestBody Place place) {
		place.setUser(new User(id, "", "",""));
		service.addNewPlace(place);
	}
	
	@PatchMapping("/api/v1/place/{userName}")
	void addNewPlace(@PathVariable String userName, @RequestBody Place place) {
		place.setUser(new User("",userName, ""));
		service.addNewPlace(place);
	}
	
	@PutMapping("/api/v1/place/{id}")
	public void updateExistingPlace(@PathVariable Integer id, @RequestBody Place place) {
		service.updateExistingPlace(place);
	}
	
	@DeleteMapping("/api/v1/place/{id}")
	public void deleteExistingPlace(@PathVariable Integer id) {
		service.deleteExistingPlace(id);
	}

}

