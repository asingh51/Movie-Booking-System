package com.bms.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cinema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cinemaId;
	private String name;
	private int totalHalls;
	
	@ManyToOne
	@JoinColumn(name="city_id", foreignKey=@ForeignKey(name="FK_city_id"))
	private City cityId;
	
	@OneToMany(mappedBy="cinemaId",fetch=FetchType.LAZY)
	private List<CinemaHall> cinemahalls;
	
	public Cinema() {}

	public Cinema(int cinemaId, String name, int totalHalls, City cityId, List<CinemaHall> cinemahalls) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		this.totalHalls = totalHalls;
		this.cityId = cityId;
		this.cinemahalls = cinemahalls;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalHalls() {
		return totalHalls;
	}

	public void setTotalHalls(int totalHalls) {
		this.totalHalls = totalHalls;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public List<CinemaHall> getCinemahalls() {
		return cinemahalls;
	}

	public void setCinemahalls(List<CinemaHall> cinemahalls) {
		this.cinemahalls = cinemahalls;
	}
	
}
