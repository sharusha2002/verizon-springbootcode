package com.verizon.springbootjdbc.laptop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String model;
	Integer ram;
	Integer cost;
	
	public Laptop() {
		
	}

	public Laptop(String model, Integer ram, Integer cost) {
		super();
		this.model = model;
		this.ram = ram;
		this.cost = cost;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Laptop [model=" + model + ", ram=" + ram + ", cost=" + cost + "]";
	}
	
	
	
}
