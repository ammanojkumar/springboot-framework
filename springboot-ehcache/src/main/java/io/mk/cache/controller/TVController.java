package io.mk.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.cache.model.TVPrograms;
import io.mk.cache.service.TVService;

@RestController
public class TVController {

	@Autowired
	private TVService tvService;

	@RequestMapping(value = "tvprogramms/{channelId}")
	public TVPrograms getTVPrograms(@PathVariable int channelId) {
		return tvService.getTVPrograms(channelId);
	}
}
