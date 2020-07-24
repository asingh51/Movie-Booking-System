package com.bms.spring.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ShowSeat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int showSeatId;
	
	private String status;
	
	private int price;
	
	@ManyToOne
	@JoinColumn(name="cinema_seat_id",foreignKey=@ForeignKey(name="FK_cinema_Seat_Id"))
	private CinemaSeat cinemaSeatId;
	
	@ManyToOne
	@JoinColumn(name="show_main_id",foreignKey=@ForeignKey(name="FK_show_main_Id"))
	private Show showMain;
	
	@ManyToOne
	@JoinColumn(name="bookings_id",foreignKey=@ForeignKey(name="FK_bookings_Id"))
	private Booking booking;
	
}
