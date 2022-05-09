package com.moviedb.guestlogin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviedb.guestlogin.model.GuestLogin;
import com.moviedb.guestlogin.model.GuestLoginPage;
/**
 * 
 * @author Bekan
 *
 */
@RestController
public class GuestLoginPageController {

	@Value("${api.key}")
	private String apiKey;
	@Autowired
	private RestTemplate guestLoginTemp;
	@RequestMapping(value = "/guestuserlogin")
	public GuestLogin guestLogin() {
		GuestLoginPage guestLoginPage = guestLoginTemp.getForObject(
				"https://api.themoviedb.org/3/authentication/guest_session/new?api_key="+apiKey,GuestLoginPage.class);
		return new GuestLogin(guestLoginPage.isSuccess(), guestLoginPage.getGuest_session_id(), guestLoginPage.getExpires_at());
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}	
