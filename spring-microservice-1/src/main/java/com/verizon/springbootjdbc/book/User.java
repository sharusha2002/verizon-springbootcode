package com.verizon.springbootjdbc.book;


public class User {
	
	private Integer id;
	
	private String name;
	
	private String password;
	
	private String location;
	
	public User() {
		
	}
	

	public User(String name, String password, String location) {
		super();
		this.name = name;
		this.password = password;
		this.location = location;
	}
	
	

	public User(Integer id, String name, String password, String location) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.location = location;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", location=" + location + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	
	
	
	

}
