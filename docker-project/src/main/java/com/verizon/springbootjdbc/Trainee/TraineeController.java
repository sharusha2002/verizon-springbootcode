package com.verizon.springbootjdbc.Trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/trainees")
@Slf4j
public class TraineeController {

	@Autowired
	TraineeService service;
	
	@GetMapping
	public List<Trainee> getAllTrainees() {
		// TODO Auto-generated method stub
		return service.getAllTrainees();
	}

	@PostMapping
	public Trainee saveTrainee(@RequestBody Trainee trainee) {
//		log
		return service.saveTrainee(trainee);
	}

	@PutMapping
	public Trainee updateTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return service.updateTrainee(trainee);
	}

	@DeleteMapping
	public void deleteTrainee(@PathVariable Integer id) {
		// TODO Auto-generated method stub
	service.deleteTrainee(id);
		
	}



 
	
	
}
