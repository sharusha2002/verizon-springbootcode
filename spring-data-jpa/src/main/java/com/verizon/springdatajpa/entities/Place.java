package com.verizon.springdatajpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Place {
	
	@Id
	private Integer placeid;
	
	private String placename;
	
	private String placeState;
	
	@ManyToOne
	private User user;
	
	public Place() {
		
	}

	public Place(Integer placeid, String placename, String placeState, Integer userid) {
		super();
		this.placeid = placeid;
		this.placename = placename;
		this.placeState = placeState;
		this.user = new User(userid, "", "", "");
		}

	public Integer getPlaceid() {
		return placeid;
	}

	public void setPlaceid(Integer placeid) {
		this.placeid = placeid;
	}

	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getPlaceState() {
		return placeState;
	}

	public void setPlaceState(String placeState) {
		this.placeState = placeState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Place [placeid=" + placeid + ", placename=" + placename + ", placeState=" + placeState + ", user="
				+ user + "]";
	}
	
	
	

}


