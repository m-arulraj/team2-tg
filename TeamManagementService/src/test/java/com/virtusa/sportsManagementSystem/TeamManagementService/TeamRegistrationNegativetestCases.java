package com.virtusa.sportsManagementSystem.TeamManagementService;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.sportsManagementSystem.TeamManagementService.domain.Team;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TeamRegistrationNegativetestCases {
	@Autowired 
	WebApplicationContext wac;
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void testingTeamRegistrationwithEmptyUserName() throws Exception {
		
		Team team = new Team();
		team.setTeamName("");
		team.setIntroducedOn("2008");
		team.setTeamManagerId(51);
		team.setContestId(101);
	
	
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(team)));
		result.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
	}
	@Test
	public void testingTeamRegistrationwithUserName() throws Exception {
		
		Team team = new Team();
		team.setTeamName("sfff");
		team.setIntroducedOn("2008");
		team.setTeamManagerId(51);
		team.setContestId(101);
	
	
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(team)));
		result.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	@Test
	public void testingTeamRegistrationwithIntroducesYeargreaterthan4() throws Exception {
		
		Team team = new Team();
		team.setTeamName("cgh");
		team.setIntroducedOn("123551");
		team.setTeamManagerId(51);
		team.setContestId(101);
	
	
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(team)));
		result.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
		
	}
	@Test
	public void testingTeamRegistrationwithalphabeticIntroducesYear() throws Exception {
		
		Team team = new Team();
		team.setTeamName("cgh");
		team.setIntroducedOn("cxv");
		team.setTeamManagerId(51);
		team.setContestId(101);
	
	
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(team)));
		result.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
		
	}
	@Test
	public void testingTeamRegistrationwithIntroducesYear() throws Exception {
		
		Team team = new Team();
		team.setTeamName("cgh");
		team.setIntroducedOn("1234");
		team.setTeamManagerId(51);
		team.setContestId(101);
	
	
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(team)));
		result.andExpect(MockMvcResultMatchers.status().isCreated());
		
	}

}
