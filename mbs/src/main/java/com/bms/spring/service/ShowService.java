package com.bms.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.spring.repository.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepo;

/*	public List<Integer> getShowByHallId(Integer cinemaHallId) {
		
		return showRepo.getShowIdByCinemaHallId(cinemaHallId);
	}
	
	public Integer getMovieByShow(int showId) {
		
		return  showRepo.getMovieIdByShowId(showId);
	}*/
}
