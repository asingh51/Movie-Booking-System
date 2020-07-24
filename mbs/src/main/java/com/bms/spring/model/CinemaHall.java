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
import javax.persistence.OneToOne;

@Entity
public class CinemaHall {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cinemaHallId;
	private String name;
	private int totalSeats;
	
	@ManyToOne
	@JoinColumn(name="cinema_id",foreignKey=@ForeignKey(name="Fk_cinema_Id"))
	private Cinema cinemaId;
	
	@OneToMany(mappedBy="cinemaHall",fetch=FetchType.LAZY)
	private List<CinemaSeat> cinemaSeats;
	
	@OneToOne
	@JoinColumn(name="show_id",foreignKey=@ForeignKey(name="FK_show_showid"))
	private Show show;
	
	public CinemaHall() {}

	public CinemaHall(int cinemaHallId, String name, int totalSeats, Cinema cinemaId, List<CinemaSeat> cinemaSeats,
			Show show) {
		super();
		this.cinemaHallId = cinemaHallId;
		this.name = name;
		this.totalSeats = totalSeats;
		this.cinemaId = cinemaId;
		this.cinemaSeats = cinemaSeats;
		this.show = show;
	}

	public int getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(int cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Cinema getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Cinema cinemaId) {
		this.cinemaId = cinemaId;
	}

	public List<CinemaSeat> getCinemaSeats() {
		return cinemaSeats;
	}

	public void setCinemaSeats(List<CinemaSeat> cinemaSeats) {
		this.cinemaSeats = cinemaSeats;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
}
