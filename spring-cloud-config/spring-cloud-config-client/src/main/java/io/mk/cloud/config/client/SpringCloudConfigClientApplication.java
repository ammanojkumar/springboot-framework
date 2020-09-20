package io.mk.cloud.config.client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	@Value("${cloud-prop1}")
	private String cloudProp1;

	@PostConstruct
	public void printCloudConfigs() {
		System.out.println("cloud property 1: " + cloudProp1);
	}

}
