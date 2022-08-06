package io.mk.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.mongo.model.TVChannel;
import io.mk.mongo.repo.TVRepo;

@RestController
@RequestMapping(value = "channel")
public class TVController {

	@Autowired
	TVRepo tvRepo;

	@GetMapping("findall")
	public List<TVChannel> getAllChannels() {
		return tvRepo.findAll();
	}

	@PostMapping("add")
	public String addTV(@RequestBody TVChannel tvChannel) {
		TVChannel res = tvRepo.save(tvChannel);
		return "New channal is created";
	}

}
