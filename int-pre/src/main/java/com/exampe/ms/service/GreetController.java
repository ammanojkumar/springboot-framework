package com.exampe.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Autowired
	@Qualifier("g2")
	private GreetServiceInf greetService;

	@GetMapping("hi/{name}")
	public String sayHi(@PathVariable String name) {
		return greetService.sayHi(name);
	}
}
