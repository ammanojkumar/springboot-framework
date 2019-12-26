package io.mk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mk.model.Club;
import io.mk.service.WelcomeService;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * @category Learning
 * @since Dec 2019
 */
@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;

	@GetMapping(value = "welcomeme")
	public String welcomeMe() {
		return "You are welcome";
	}

	@GetMapping(value = "welcomeme/{name}")
	public String welcomeMe(@PathVariable String name) {
		return "WELCOME " + name;
	}

	@RequestMapping(value = "welcomeall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String welcomeAll(@RequestBody Club club) {
		String response = welcomeService.welcomeAll(club);
		return response;
	}
}
