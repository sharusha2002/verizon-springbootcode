package com.verizon.springreactive.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String model;
	private String ram;
	
	public Laptop() {
		
	}

	public Laptop(String name, String model, String ram) {
		super();
		this.name = name;
		this.model = model;
		this.ram = ram;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", model=" + model + ", ram=" + ram + "]";
	}
	
	
	
	

}
