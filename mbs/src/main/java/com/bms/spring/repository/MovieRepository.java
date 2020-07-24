package com.bms.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bms.spring.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

	/*@Query("select * from Movie where ")
	List<Movie> getMovieByShowId(Integer showId);*/
	
	
}
