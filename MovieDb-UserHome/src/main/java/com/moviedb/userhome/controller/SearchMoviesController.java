package com.moviedb.userhome.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviedb.userhome.model.MovieDetailsModel;
/**
 * 
 * @author Bekan
 * @Version 1.0.1
 */
@RestController
public class SearchMoviesController {

	@Value("${api.key}")
	private String apiKey;
	@Autowired
	RestTemplate movieSearch;
	/**
	 * 
	 * @param Requires input query string movie_Name
	 * @return Shows movies matching the search query
	 */
	@RequestMapping("/serachmovies/{movie_Name}")
	public MovieDetailsModel searchMovies(@PathVariable String movie_Name){
		String url = "https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&language=en-US&query="+movie_Name+"&page=1&include_adult=false";
		MovieDetailsModel searchMovies = movieSearch.getForObject(url, MovieDetailsModel.class);
		return searchMovies;
	}
	@Bean
	RestTemplate template() {
		return new RestTemplate();
	}
}
