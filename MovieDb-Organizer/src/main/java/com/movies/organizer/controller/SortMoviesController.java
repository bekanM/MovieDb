package com.movies.organizer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movies.organizer.model.Movies;
@RequestMapping("/sortMovies")
@RestController
public class SortMoviesController {

	@Autowired
	private RestTemplate sortMovies;
	@Value("${api.key}")
	private String apiKey;
	@RequestMapping("/sortby_name_asc")
	public List<Movies> sortByName() {
		String url = "https://api.themoviedb.org/3/discover/movie?api_key="+apiKey+"&language=en-US&sort_by=original_title.asc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=free";
		Movies byName = sortMovies.getForObject(url, Movies.class);
		return Arrays.asList(byName);
	}

	@RequestMapping("/sortby_rating")
	public List<Movies> sortByRating(){
		String url = "https://api.themoviedb.org/3/discover/movie?api_key="+apiKey+"&language=en-US&sort_by=vote_average.asc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=free";
		Movies byRating = sortMovies.getForObject(url, Movies.class);
		return Arrays.asList(byRating);
	} 

	@RequestMapping("/sortby_release_date")
	public List<Movies> sortByReleaseDate(){
		String url = "https://api.themoviedb.org/3/discover/movie?api_key="+apiKey+"&language=en-US&sort_by=primary_release_date.asc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=free";
		Movies byReleaseDate = sortMovies.getForObject(url, Movies.class);
		return Arrays.asList(byReleaseDate);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
