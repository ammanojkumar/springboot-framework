package io.mk.annotation.core.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileExampleController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("profile")
	public String printDbDetail() throws Exception {
		profileService.printActiveProfileDetails();
		return "Profile: printing DB details in colsole";
	}

}
