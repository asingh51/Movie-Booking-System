package com.bms.spring.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="show_table")
public class Show {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int showId;
	
	private Date showDate;
	private Date startTime;
	private Date endTime;
	
	@OneToOne
	@JoinColumn(name="cinemahall_id",foreignKey=@ForeignKey(name="FK_cinemahall_id"))
	private CinemaHall cinemaHallId;
	
	@OneToMany(mappedBy="showBooking")
	private List<Booking> bookingId;
	
	@OneToMany(mappedBy="showMain")
	private List<ShowSeat> showseat;
	
	@ManyToOne
	@JoinColumn(name="movie_id",foreignKey=@ForeignKey(name="FK_movie_id"))
	@JsonIgnore
	private Movie movie; 
	
	public Show() {}

	public Show(int showId, Date showDate, Date startTime, Date endTime, CinemaHall cinemaHallId,
			List<Booking> bookingId, List<ShowSeat> showseat, Movie movie) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cinemaHallId = cinemaHallId;
		this.bookingId = bookingId;
		this.showseat = showseat;
		this.movie = movie;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public CinemaHall getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(CinemaHall cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

	public List<Booking> getBookingId() {
		return bookingId;
	}

	public void setBookingId(List<Booking> bookingId) {
		this.bookingId = bookingId;
	}

	public List<ShowSeat> getShowseat() {
		return showseat;
	}

	public void setShowseat(List<ShowSeat> showseat) {
		this.showseat = showseat;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
