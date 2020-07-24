package com.bms.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.spring.model.Cinema;
import com.bms.spring.model.CinemaHall;
import com.bms.spring.model.City;
import com.bms.spring.model.Movie;
import com.bms.spring.model.Show;
import com.bms.spring.service.CinemaHallService;
import com.bms.spring.service.CityService;
import com.bms.spring.service.MovieService;
import com.bms.spring.service.ShowService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private CityService cityService;

	@Autowired
	private CinemaHallService cinemaHallService;

	@Autowired ShowService showService;

	@RequestMapping(value="/movies", method=RequestMethod.GET/*, produces="application/json"*/)
	public List<Movie> getMovies() /*throws JSONException, JsonProcessingException*/{

		/*JSONObject response = new JSONObject();
		List<Movie> movieList = movieService.getMovies();
		System.out.println("hi"+movieList.toString());
		ObjectWriter writer = new ObjectMapper().writer();


		JSONArray movieArray = new JSONArray();
		if(!movieList.isEmpty()) {
			for (Movie movie : movieList) {
				JSONObject json = new JSONObject(writer.writeValueAsString(movie));
				movieArray.put(json);
			}
			response.put("movieList", movieArray);
			response.put("status","Success");

		}else {
			response.put("message", "Sorry, no movies being screened at this time");
			response.put("status", "Fail");
		}*/


		return movieService.getMovies();
	}

	/*@RequestMapping("/movies/{id}")
	public Optional<Movie> getMovieId(@PathVariable String id) throws JSONException, JsonProcessingException{

		JSONObject response = new JSONObject();
		Optional<Movie> movie = movieService.getMovieById(id);

		ObjectWriter writer = new ObjectMapper().writer();

		if(movie.isPresent()) {
			response.put("movieObj", new JSONObject(writer.writeValueAsString(movie.get())));
			response.put("status", "Success");
		}else {
			response.put("message", "This movie does not exist");
			response.put("status", "Fail");
		}

		return movieService.getMovieById(id);
	}*/

	@RequestMapping("/movies/{cityName}")
	public List<Movie> getMovieCity(@PathVariable String cityName) throws JSONException, JsonProcessingException{

		//	Optional<Integer> cityId = cityService.getCityIdByName(cityName);
		List<Cinema> cinemaList = new ArrayList<>();
		List<CinemaHall> cinemaHallList = new ArrayList<>();

		List<Show> showList = new ArrayList<>();
		List<Movie> movieList = new ArrayList<>();

		Optional<City> city = cityService.getCityByName(cityName);
		System.out.println(city.get().getState());

		if(city.isPresent()) {
			cinemaList = city.get().getCinemas();

			for (Cinema cinema : cinemaList) {
				cinemaHallList.addAll(cinema.getCinemahalls());
			}

			for (CinemaHall cinemaHall : cinemaHallList) {
				showList.add(cinemaHall.getShow());
			}	

			for (Show show : showList) {
				System.out.println("AAAAA");
				movieList.add(show.getMovie());
			}

		}
		return movieList;
	}

	@RequestMapping(method=RequestMethod.POST, value="/movies")
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovieToList(movie);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/movies/{id}")
	public void deleteMovie(@RequestBody Movie movie) {
		movieService.deleteMovie(movie);
	}
}
