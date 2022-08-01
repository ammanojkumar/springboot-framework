package mk.io.oauth2.client;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("signin")
	public String signIn(Principal principal) {
		return principal.getName() + " you have signedin successfully.";
	}
}
