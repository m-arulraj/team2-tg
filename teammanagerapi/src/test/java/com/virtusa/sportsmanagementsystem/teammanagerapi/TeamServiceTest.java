package com.virtusa.sportsmanagementsystem.teammanagerapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
public class TeamServiceTest {

	@Autowired
	WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); 
	}
	@Test
	public void creatingTeam() throws Exception {
		
		Team team = new Team();
		team.setTeamName("MI");
		team.setIntroducedOn("2008");
		team.setTeamManagerId(51);
		team.setContestId(101);
	
	
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.post("/api/team")
				.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(team)));
		result.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	@Test
	public void getListOfTeams() throws Exception {
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.get("/api/team")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Test public void getListOfplayers() throws Exception { ResultActions
	 * result=mockMvc.perform(MockMvcRequestBuilders.get("/api/team/getplayers?id=")
	 * .contentType(MediaType.APPLICATION_JSON));
	 * result.andExpect(MockMvcResultMatchers.status().isOk()); }
	 */
	@Test
	public void registringPlayer() throws Exception {
		
	Player player = new Player();
	player.setPlayerName("Chahelw");
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
		result.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	 
	@Test
	public void getplayerListbasedOnRole() throws Exception {
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.get("/api/team/players?playerRole=Batsmen")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void getplayerListbasedOnTeam() throws Exception {
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.get("/api/team/playersBasedOnTeam?id=84")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void getTeamBasedOnPlayer() throws Exception {
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.get("/api/team/Team-Player?id=166")
				.contentType(MediaType.APPLICATION_JSON));
		result.andExpect(MockMvcResultMatchers.status().isOk()); 
	}
}
