package io.mk.annotation.core.qualifier;

import org.springframework.stereotype.Service;

@Service("tiger")
public class TigerService implements AnimalService {

	@Override
	public String getAnimalName() {
		return "Tiger";
	}
}
