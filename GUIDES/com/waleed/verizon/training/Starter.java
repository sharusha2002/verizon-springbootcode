package com.waleed.verizon.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


//class Dog{
//	
//}


class SortStudentsById implements Comparator<Student>{

	@Override
	public int compare(Student firstStudent, Student secondStudent) {
		return firstStudent.getId().compareTo(secondStudent.getId());
	}
	
}

class SortStudentsByName implements Comparator<Student>{
	@Override
	public int compare(Student firstStudent, Student secondStudent) {
		return firstStudent.getName().compareTo(secondStudent.getName());
	}
}

class SortStudentsBySkills implements Comparator<Student>{
	@Override
	public int compare(Student firstStudent, Student secondStudent) {
		return firstStudent.getSkills().compareTo(secondStudent.getSkills());
	}
}







public class Starter {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(34, "Ravi", "HTML"));
		students.add(new Student(411, "Abbas", "Python"));
		students.add(new Student(210, "Sanjana", "CSS"));
		students.add(new Student(12, "Mushtaq", "CSS"));
		students.add(new Student(246, "Shabrin", "Java"));
		
		students.forEach(System.out::println);
		
//		Sort the list of students
		Collections.sort(students, new SortStudentsBySkills());
		
		System.out.println("----------------------");
		
		System.out.println("After sorting, list :");
		
		students.forEach(System.out::println);

//		ArrayList<String> listOfNames = new ArrayList<>();
//		
//		System.out.println("Enter 5 student names");
//		
//		for(int index = 0; index < 5; index++) {
//			listOfNames.add(scan.nextLine());
//		}
//		
////		listOfNames.forEach(System.out::println);
//		System.out.println("Before sorting: ");
//		System.out.println(listOfNames);
//		
////		Sort the list
//		Collections.sort(listOfNames);
//		
////		Or with java 8 sorting:
////		listOfNames.sort();
//		
//		System.out.println("----------------------");
//		System.out.println("After sorting, list : ");
//		System.out.println(listOfNames);
		
		
		
//		Dog dog = new Dog();
//		
//		Student firstStudent = new Student(23, "Anshu", "Python");
//		Student secondStudent = new Student(21, "Mahesh", "Python");
//		
//		
//		if(firstStudent.equals(secondStudent)) {
//			System.out.println("Same students");
//		}else {
//			System.out.println("Different students");
//		}
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println("Registered students are : ");
		
//		listOfNames.forEach(System.out::println);
		
		
		
		
		

//		Engineer[] engineers = new Engineer[30];

//		ArrayList<VerizonEmployee> employees = new ArrayList<>();

//		System.out.println(employees.size());

//		System.out.println("Enter Engineer details");

//		String userInput = "Yes";
//
//		do {
//
//			System.out.println("Enter name, domain, id");
//
//			employees.add(new VerizonEmployee(theScan.nextLine(), theScan.nextLine(), theScan.nextInt()));
//
//			theScan.nextLine();
//
//			System.out.println("Do you want to register more employees?(Yes/No?)");
//			userInput = theScan.nextLine();
//
//		} while (userInput.equalsIgnoreCase("Yes"));

//		employees.remove(0);

//		Display all engineer data:

//		System.out.println("Registered employees : ");
//
//		for (VerizonEmployee employee : employees) {
//			System.out.println(employee.name());
//		}
		
//		Lombok

//		Collections
//			- Growable
//			- Shrinkable
//			- Sortable
//			- Searchable

//			java.util

	}
}

interface Engineer{
	
}

// Java 16 records
//record identifier(Component Fields){}

record VerizonEmployee(String name, String domain, Integer id) implements Engineer {
}






//class VerizonEmployee {// implements Engineer {
//	private Integer id;
//
//	private String name;
//
//	private String domain;
//
//	@Override
//	public String toString() {
//		return "VerizonEmployee [id=" + id + ", name=" + name + ", domain=" + domain + "]";
//	}
//
//	public VerizonEmployee(Integer id, String name, String domain) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.domain = domain;
//	}
//
//	public VerizonEmployee() {
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDomain() {
//		return domain;
//	}
//
//	public void setDomain(String domain) {
//		this.domain = domain;
//	}
//
//}