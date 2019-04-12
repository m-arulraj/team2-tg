package com.sms.scoreboardapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.sms.scoreboardapi.domain.BallScore;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MatchScoreTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void testUpdationForNewMatch() throws Throwable{
		BallScore ballScore= new BallScore();
		ballScore.setBallNumber(1);
		ballScore.setRuns(4);
		ballScore.setWicket(false);
		ballScore.setBattingPlayerId(Long.valueOf(172));
		ballScore.setBowlingPlayerId(Long.valueOf(171));
		ballScore.setMatchStatus("on-going");
		ballScore.setScheduleId(Long.valueOf(2));
		
		String uri="/api/scoreboard/matchscore";
				
		mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(ballScore)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void testUpdation() throws Throwable{
		BallScore ballScore= new BallScore();
		ballScore.setBallNumber(3);
		ballScore.setRuns(6);
		ballScore.setWicket(false);
		ballScore.setBattingPlayerId(Long.valueOf(172));
		ballScore.setBowlingPlayerId(Long.valueOf(171));
		ballScore.setMatchStatus("on-going");
		ballScore.setScheduleId(Long.valueOf(1));
		
		String uri="/api/scoreboard/matchscore";
				
		mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(ballScore)))
				.andExpect(MockMvcResultMatchers.status().isOk());
				//.andReturn().getResponse().getHeader("Location").toString();
		
		
	}
	
	@Test
	public void getMatchScore()throws Throwable {
	
		String uri="/api/scoreboard/matchscore/1";
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getPlayerMatchPerformance()throws Throwable {
	
		String uri="/api/scoreboard/matchscore/player-match-performance/86/1";
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getPlayerContestPerformance()throws Throwable {
	
		String uri="/api/scoreboard/matchscore/player-contest-performance/86/101";
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getPlayerTeamPerformance()throws Throwable {
	
		String uri="/api/scoreboard/matchscore/team-performance/84";
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
