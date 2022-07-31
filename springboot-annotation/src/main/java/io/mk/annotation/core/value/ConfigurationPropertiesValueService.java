package io.mk.annotation.core.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationPropertiesValueService {

	@Autowired
	private MailProperties mailProps;

	public String getValues() {
		return mailProps.getHost();
	}
}
