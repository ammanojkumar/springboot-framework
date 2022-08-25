package io.mk.kafka.pub;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootKafkaPubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaPubApplication.class, args);
	}

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@PostConstruct
	public void publishMessages() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Publishing " + i);
				kafkaTemplate.send("first-topic", new News(String.valueOf(i), "News" + i));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
