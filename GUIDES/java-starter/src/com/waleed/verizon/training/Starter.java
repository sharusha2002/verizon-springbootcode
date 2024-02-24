package com.waleed.verizon.training;

import java.util.ArrayList;
import java.util.Scanner;

public class Starter {
	public static void main(String[] args) {

		
		Scanner theScan = new Scanner(System.in);
		
//		Engineer[] engineers = new Engineer[30];
		
		ArrayList<VerizonEmployee> employees = new ArrayList<>();
		
//		System.out.println(employees.size());
		
		System.out.println("Enter Engineer details");
		
		String userInput = "Yes";
		
		do {
		
	
			System.out.println("Enter name, domain, id");
			
employees.add(
		new VerizonEmployee(
				theScan.nextLine(),
				theScan.nextLine(),
				theScan.nextInt())
		);

			theScan.nextLine();
			
			System.out.println("Do you want to register more employees?(Yes/No?)");
			userInput = theScan.nextLine();
			
		}while(userInput.equalsIgnoreCase("Yes"));
		
		
		
//		employees.remove(0);
				
		
		
//		Display all engineer data:
		
		System.out.println("Registered employees : ");
		
		for(VerizonEmployee employee : employees) {
			System.out.println(employee);
		}
		
//		Collections
//			- Growable
//			- Shrinkable
//			- Sortable
//			- Searchable
			
//			java.util
		
		
		
		
		
		

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
