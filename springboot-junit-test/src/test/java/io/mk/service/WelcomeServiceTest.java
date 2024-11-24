package io.mk.service;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import io.mk.model.Club;

@RunWith(SpringRunner.class)
public class WelcomeServiceTest {

	@InjectMocks
	private WelcomeService welcomeService;

	@Test
	public void welcomeAllTest() {
		Club club = new Club();
		club.setMembersNames(Arrays.asList(new String[] { "Name1", "Name2", "Name3" }));

		String response = welcomeService.welcomeAll(club);
		Assert.assertThat(response, CoreMatchers.containsString("Welcome:"));
	}
}
