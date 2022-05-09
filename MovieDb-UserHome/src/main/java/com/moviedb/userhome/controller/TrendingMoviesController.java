package com.moviedb.userhome.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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
public class TrendingMoviesController {

	@Autowired
	private RestTemplate trendingTemp;
	@Value("${api.key}")
	private String apiKey;
	/**
	 * 
	 * @return Trending movies list for the day
	 */
	@RequestMapping(value="/trendingtoday")
	public List<MovieDetailsModel> getTrending() {
			String url = "https://api.themoviedb.org/3/trending/movie/day?api_key="+apiKey;
			MovieDetailsModel dayTrend = trendingTemp.getForObject(url, MovieDetailsModel.class);
			return Arrays.asList(dayTrend);
	}
	/**
	 * 
	 * @return Trending movies list for the week
	 */
	@RequestMapping(value = "/weeklytrending")
	public List<MovieDetailsModel> weeklyTrending(){
			String url = "https://api.themoviedb.org/3/trending/movie/week?api_key="+apiKey;
			MovieDetailsModel weeklyTrend = trendingTemp.getForObject(url, MovieDetailsModel.class);
			return Arrays.asList(weeklyTrend);
	}
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
