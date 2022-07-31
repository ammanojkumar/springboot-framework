package io.mk.annotation.core.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	public void printActiveProfileDetails() {
		System.out.println(url + ", " + username + ", " + password);
	}

}
