package io.mk.annotation.core.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApplicationPropertiesService {

	@Value("${spring.mail.host}")
	private String host;

	public String getValues() {
		return host;
	}
}
