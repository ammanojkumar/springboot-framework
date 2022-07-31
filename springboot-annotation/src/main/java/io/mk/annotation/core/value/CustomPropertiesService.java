package io.mk.annotation.core.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom-url.properties")
public class CustomPropertiesService {

	@Value("${service.url.product}")
	private String firstName;

	public String getValues() {
		return firstName;
	}
}
