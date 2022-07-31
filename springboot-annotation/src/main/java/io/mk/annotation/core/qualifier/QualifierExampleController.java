package io.mk.annotation.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QualifierExampleController {

	@Autowired
	@Qualifier("tiger")
	private AnimalService animalService;

	@GetMapping("animal")
	public String getAnimalName() {
		return "QualifierExample: " + animalService.getAnimalName();
	}

}
