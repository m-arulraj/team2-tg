package com.virtusa.sportsmanagementsystem.teammanagerapi;

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
import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Player;
import com.virtusa.sportsmanagementsystem.teammanagerapi.domain.Team;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PlayerNegativeTest {

	@Autowired 
	WebApplicationContext wac;
	MockMvc mockMvc;
	
	@Before
	public  void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();		
	}
	
	@Test
	public void testingregistringPlayerwithEmptyName() throws Exception {
		
	Player player = new Player();
	player.setPlayerName("");
	player.setPlayerRole("Bowler");
	player.setPlayerDob("01-02-2001");
	player.setBirthPlace("Delhi");
	player.setBattingStyle("rightHand");
	Team team = new Team(); 
	team.setTeamName("RCB");
	
	player.setTeam(team);
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team/player")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(player)));
		result.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
	}
	@Test
	public void testingregistringPlayerwithName() throws Exception {
		
	Player player = new Player();
	player.setPlayerName("");
	player.setPlayerRole("Bowler");
	player.setPlayerDob("01-02-2001");
	player.setBirthPlace("Delhi");
	player.setBattingStyle("rightHand");
	Team team = new Team(); 
	team.setTeamName("RCB");
	
	player.setTeam(team);
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team/player")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(player)));
		result.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
	}
}
