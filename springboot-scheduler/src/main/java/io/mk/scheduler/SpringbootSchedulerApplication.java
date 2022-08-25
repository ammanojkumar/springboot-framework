package io.mk.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchedulerApplication.class, args);
	}

}
