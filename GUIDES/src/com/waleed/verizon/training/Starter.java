package com.waleed.verizon.training;

import java.util.Scanner;

public class Starter {
//	Student arr[];
	public static void main(String[] args) {

		
		Scanner theScan = new Scanner(System.in);
		
		Engineer[] engineers = new Engineer[3];
		
		System.out.println("Enter Engineer details");
		
		for(int index = 0; index < engineers.length; index++) {
			
			System.out.println("Enter name, domain, id");
			
			engineers[index] = new VerizonEmployee(theScan.nextLine(), theScan.nextLine(), theScan.nextInt());
			theScan.nextLine();
				
		}
		
		
//		Display all engineer data:
		
		System.out.println("Registered employees : ");
		
		for(Engineer employee : engineers) {
			System.out.println(employee);
		}
		
		

	}
}

interface Engineer {

}

class VerizonEmployee implements Engineer {
	private Integer id;

	private String name;

	private String domain;

	public VerizonEmployee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VerizonEmployee [id=" + id + ", name=" + name + ", domain=" + domain + "]";
	}

	public VerizonEmployee(String name, String domain, Integer id) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
