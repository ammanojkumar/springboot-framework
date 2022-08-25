package io.mk.kafka.sub;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootKafkaSubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaSubApplication.class, args);
	}

	@KafkaListener(groupId = "first-group", topics = {
			"first-topic" }, containerFactory = "kafkaListenerContainerFactory")
	public List<String> getTopicMessages(String message) {
		System.out.println("Consumed message is " + message);
		return null;
	}
}
