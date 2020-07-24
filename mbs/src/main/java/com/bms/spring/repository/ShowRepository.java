package com.bms.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bms.spring.model.Show;

public interface ShowRepository extends CrudRepository<Show, Integer> {

	/*@Query("select showId from Show where cinemaHallId = ?1")
	List<Integer> getShowIdByCinemaHallId(Integer cinemaHallId);

	@Query("select movie_id from Show where showId=?1")
	Integer getMovieIdByShowId(int showId);
*/
}
