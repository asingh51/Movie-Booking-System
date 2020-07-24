package com.bms.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.spring.model.Movie;
import com.bms.spring.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getMovies() {
		return (List<Movie>) movieRepository.findAll();
	}
	
	public Optional<Movie> getMovieById(Integer movieId) {
		return movieRepository.findById(movieId);
	}

	public void addMovieToList(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

	/*public List<Movie> getMovieByShowId(Integer showId) {
		return movieRepository.getMovieByShowId(showId);
	}*/
	
}
