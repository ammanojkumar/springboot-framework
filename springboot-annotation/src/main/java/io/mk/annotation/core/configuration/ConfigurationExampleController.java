package io.mk.annotation.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationExampleController {

	@Autowired
	private PrintService printService;

	@GetMapping("greetme")
	public String greetme() {
		return "ConfigurationExample: " + printService.greetme();
	}

}
