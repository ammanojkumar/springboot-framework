package io.mk.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.mk.model.Club;
import io.mk.service.WelcomeService;

@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WelcomeService welcomeService;

	@Test
	public void welcomeMeTest() throws Exception {
		this.mockMvc.perform(get("/welcomeme")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("You are welcome")));
	}

	@Test
	public void welcomeMeWithNameTest() throws Exception {
		this.mockMvc.perform(get("/welcomeme/Manoj")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("WELCOME")));
	}

	@Test
	public void welcomeAllTest() throws Exception {
		Club club = new Club();
		club.setMembersNames(Arrays.asList(new String[] { "Name1", "Name2", "Name3" }));

		when(welcomeService.welcomeAll(any(Club.class))).thenReturn("Welcome All");
		MvcResult response = this.mockMvc
				.perform(post("/welcomeall").content(new ObjectMapper().writeValueAsString(club))
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Welcome All")))
				.andReturn();
		System.out.println(response.getResponse().getContentAsString());
	}
}
