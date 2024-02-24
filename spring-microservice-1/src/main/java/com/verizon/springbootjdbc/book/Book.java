package com.verizon.springbootjdbc.book;

public class Book {
	
	private Integer id;
	private String name;
	private String genre;
	private String description;
	
	public Book() {
		
	}

	public Book(Integer id, String name, String genre, String description) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.description = description;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", genre=" + genre + ", description=" + description + "]";
	}
	
	

}
