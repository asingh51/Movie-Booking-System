package com.bms.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cityId;
	private String name;
	private String state;
	private String zipCode;
	
	@OneToMany(mappedBy="cityId",fetch=FetchType.LAZY)
	private List<Cinema> cinemas;
	
	public City() {}
	
	public City(int cityId, String name, String state, String zipCode, List<Cinema> cinemas) {
		super();
		this.cityId = cityId;
		this.name = name;
		this.state = state;
		this.zipCode = zipCode;
		this.cinemas = cinemas;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

}
