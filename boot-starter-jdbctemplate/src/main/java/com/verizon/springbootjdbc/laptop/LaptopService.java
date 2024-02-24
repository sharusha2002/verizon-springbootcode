package com.verizon.springbootjdbc.laptop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

//    public List<Laptop> getAllLaptops() {
//        return laptopRepository.getAllLaptops();
//    }
//
//    public Laptop getLaptopById(Integer id) {
//        return laptopRepository.getLaptopById(id);
//    }
//
//    public int createNewLaptop(Laptop laptop) {
//        return laptopRepository.createNewLaptop(laptop);
//    }
//    
//    public int updateLaptop(Integer id, Laptop laptop) {
//    	return laptopRepository.updateLaptop(id, laptop);
//    }
//    
//    public int deleteLaptop(Integer id) {
//    	return laptopRepository.deleteLaptop(id);
//    }
    
    public Iterable<Laptop> getAllLaptops() {
    	return laptopRepository.findAll();
    }
    
    public Optional<Laptop> getLaptopsById(Integer id) {
		return laptopRepository.findById(id);
    	
    	
    }
    
    public Laptop createNewLaptop(Laptop laptop) {
    	return laptopRepository.save(laptop);
    }
    
    public void updateExistingLaptop(Laptop laptop) {
    	laptopRepository.save(laptop);
    }
    
    public void deleteExistingLaptop(Integer id) {
    	laptopRepository.deleteById(id);
    }
}
