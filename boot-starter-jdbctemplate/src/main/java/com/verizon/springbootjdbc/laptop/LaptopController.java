package com.verizon.springbootjdbc.laptop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @GetMapping("/laptops/{id}")
    Optional<Laptop> getLaptopsById(@PathVariable Integer id) {
        return laptopService.getLaptopsById(id);
    }

    @PostMapping("/laptop/{id}")
    Laptop createNewLaptop(@PathVariable Integer id, @RequestBody Laptop laptop) {
        return laptopService.createNewLaptop(laptop);
    }

    @GetMapping("/laptops")
    public Iterable<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }
    
    @PutMapping("/laptop/{id}")
    public void updateExistingLaptop(@PathVariable Integer id, @RequestBody Laptop laptop) {
    	laptopService.updateExistingLaptop(laptop);
    }
    
    @DeleteMapping("/laptop/{id}")
    void deleteExistingLaptop(@PathVariable Integer id) {
    	laptopService.deleteExistingLaptop(id);
    }
}

