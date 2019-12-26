package io.mk.service;

import org.springframework.stereotype.Service;

import io.mk.model.Club;

@Service
public class WelcomeService {

	public String welcomeAll(Club club) {
		StringBuilder builder = new StringBuilder();
		for (String name : club.getMembersNames()) {
			builder.append("Welcome: ").append(name).append("\n");
		}
		return builder.toString();
	}
}
