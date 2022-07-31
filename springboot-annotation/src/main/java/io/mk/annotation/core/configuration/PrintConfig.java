package io.mk.annotation.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintConfig {

	@Bean
	public PrintService getPrintService() {
		return new PrintService();
	}
}
