package com.verizon.springbootjdbc.Trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TraineeServiceImpl implements TraineeService{
	private TraineeRepository repository;

	@Autowired
	public TraineeServiceImpl(TraineeRepository repository) {
		
		this.repository = repository;
	}

	@Override
	public List<Trainee> getAllTrainees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Trainee saveTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return repository.save(trainee);
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return repository.save(trainee);
	}

	@Override
	public void deleteTrainee(Integer id) {
		// TODO Auto-generated method stub
	repository.deleteById(id);
		
	}




}
