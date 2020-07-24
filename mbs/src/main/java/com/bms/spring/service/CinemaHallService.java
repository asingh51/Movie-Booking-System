package com.bms.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.spring.repository.CinemaHallRepository;

@Service
public class CinemaHallService {

	@Autowired
	private CinemaHallRepository cinemaHallRepository;

	public List<Integer> getHallByCinemaId(int cinemaId) {
		
		return cinemaHallRepository.getHallIdByCinemaId(cinemaId);
	}
}
