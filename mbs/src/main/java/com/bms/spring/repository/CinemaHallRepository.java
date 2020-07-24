package com.bms.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bms.spring.model.CinemaHall;

public interface CinemaHallRepository extends CrudRepository<CinemaHall, Integer> {

	@Query("select cinemaHallId from CinemaHall where cinema_id=?1")
	public List<Integer> getHallIdByCinemaId(int cinemaId);

}
