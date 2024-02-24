package com.verizon.assessment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer album_id;
	private String title;
	private String artist;
	private Double price;
	
	public Album() {
		
	}

	public Album(Integer album_id, String title, String artist, Double price) {
		super();
		this.album_id = album_id;
		this.title = title;
		this.artist = artist;
		this.price = price;
	}

	public Integer getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(Integer album_id) {
		this.album_id = album_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Album [album_id=" + album_id + ", title=" + title + ", artist=" + artist + ", price=" + price + "]";
	}
	
	


	
	
}
