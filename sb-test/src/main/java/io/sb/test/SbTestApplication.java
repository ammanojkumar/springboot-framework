package io.sb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbTestApplication {

	@Autowired
	MySingletonBean bean;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SbTestApplication.class, args);
	}

	@GetMapping
	public void print() throws Exception {
		bean.showMessage();
		Thread.sleep(1000);
		bean.showMessage();
	}

}
