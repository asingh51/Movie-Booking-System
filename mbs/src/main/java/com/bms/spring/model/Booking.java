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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	private int seatsBooked;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeOfBooking;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="show_booking_id",foreignKey=@ForeignKey(name="Fk_show_Id"))
	private Show showBooking;
	
	@OneToMany(mappedBy="booking")
	private List<ShowSeat> showSeat;
	
	public Booking() {}

	public Booking(int bookingId, int seatsBooked, Date timeOfBooking, String status, Show showBooking,
			List<ShowSeat> showSeat) {
		super();
		this.bookingId = bookingId;
		this.seatsBooked = seatsBooked;
		this.timeOfBooking = timeOfBooking;
		this.status = status;
		this.showBooking = showBooking;
		this.showSeat = showSeat;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Date getTimeOfBooking() {
		return timeOfBooking;
	}

	public void setTimeOfBooking(Date timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Show getShowBooking() {
		return showBooking;
	}

	public void setShowBooking(Show showBooking) {
		this.showBooking = showBooking;
	}

	public List<ShowSeat> getShowSeat() {
		return showSeat;
	}

	public void setShowSeat(List<ShowSeat> showSeat) {
		this.showSeat = showSeat;
	}
	
}
