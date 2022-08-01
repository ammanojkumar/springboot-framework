package mk.io.oauth2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class Oauth2clientGithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2clientGithubApplication.class, args);
	}

}
