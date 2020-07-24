package com.bms.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@JsonIgnoreType
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	private String title;
	private int duration;
	private String language;
	private Date releaseDate;
	private String country;
	private String genre;
	
	@OneToMany(mappedBy="movie",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Show> shows;
	
	public Movie() {}

	public Movie(int movieId, String title, int duration, String language, Date releaseDate, String country,
			String genre, List<Show> shows) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.duration = duration;
		this.language = language;
		this.releaseDate = releaseDate;
		this.country = country;
		this.genre = genre;
		this.shows = shows;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", duration=" + duration + ", language=" + language
				+ ", releaseDate=" + releaseDate + ", country=" + country + ", genre=" + genre + ", shows=" + shows
				+ "]";
	}
}
