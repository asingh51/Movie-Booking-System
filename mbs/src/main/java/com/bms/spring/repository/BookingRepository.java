package com.bms.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.bms.spring.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
