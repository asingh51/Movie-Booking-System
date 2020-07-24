package com.bms.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CinemaSeat {
	
	@Id
	private int cinemaSeatId;
	private int seatNumber;
	
	@ManyToOne
	@JoinColumn(name="cinema_Hall",foreignKey=@ForeignKey(name="FK_cinema_hall_Id"))
	private CinemaHall cinemaHall;
	
	@OneToMany(mappedBy="cinemaSeatId")
	private List<ShowSeat> showSeats;
	
	public CinemaSeat() {}

	public CinemaSeat(int cinemaSeatId, int seatNumber, CinemaHall cinemaHall, List<ShowSeat> showSeats) {
		super();
		this.cinemaSeatId = cinemaSeatId;
		this.seatNumber = seatNumber;
		this.cinemaHall = cinemaHall;
		this.showSeats = showSeats;
	}

	public int getCinemaSeatId() {
		return cinemaSeatId;
	}

	public void setCinemaSeatId(int cinemaSeatId) {
		this.cinemaSeatId = cinemaSeatId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public List<ShowSeat> getShowSeats() {
		return showSeats;
	}

	public void setShowSeats(List<ShowSeat> showSeats) {
		this.showSeats = showSeats;
	}
	
}
