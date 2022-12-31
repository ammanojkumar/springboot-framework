package io.mk.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.mk.security.service.UserRepository;
import io.mk.security.service.Users;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void addUsers() {
		String pwd = new BCryptPasswordEncoder().encode("pass");
		userRepository.save(new Users(1, "aaa", pwd, "ADMIN"));
		userRepository.save(new Users(2, "bbb", pwd, "USER"));
	}

}
