package com.verizon.springbootjdbc.Trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface TraineeService {

	List<Trainee> getAllTrainees();
	Trainee saveTrainee(Trainee trainee);
	Trainee updateTrainee(Trainee trainee);
	void deleteTrainee(Integer id);
	
	
	
	
}
