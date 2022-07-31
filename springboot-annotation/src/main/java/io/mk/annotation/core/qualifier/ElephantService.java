package io.mk.annotation.core.qualifier;

import org.springframework.stereotype.Service;

@Service("elephant")
//@Primary
public class ElephantService implements AnimalService {

	@Override
	public String getAnimalName() {
		return "Elephant";
	}
}
