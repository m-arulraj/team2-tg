package com.virtusa.sportmanagementsystem.contestownerapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.virtusa.sportmanagementsystem.contestownerapi.domain.Contest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContestTest {

	@Autowired
	WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void createContest() throws Exception {
		Contest contest = new Contest();
		contest.setContestName("IPL");
		contest.setContestType("T20");
		contest.setNumberOfTeams(8L);
		contest.setStartingDate("01/01/2001");
		contest.setCompletionDate("01/01/2003");
		contest.setUserId(100L);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/contest").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(contest))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void createContestWithWrongDates() throws Exception {
		Contest contest = new Contest();
		contest.setContestName("IPL");
		contest.setContestType("T20");
		contest.setNumberOfTeams(8L);
		contest.setStartingDate("01/01/2003");
		contest.setCompletionDate("01/01/2001");
		contest.setUserId(100L);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/contest").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(contest))).andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void createContestWithWrongDates2() throws Exception {
		Contest contest = new Contest();
		contest.setContestName("IPL");
		contest.setContestType("T20");
		contest.setNumberOfTeams(8L);
		contest.setStartingDate("01/01/2001");
		contest.setCompletionDate("01/01/2001");
		contest.setUserId(100L);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/contest").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(contest))).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void updateContestTest() throws Exception {
		Contest contest = new Contest();
		contest.setId(119L);
		contest.setContestName("VIVO IPL");
		contest.setContestType("T20");
		contest.setNumberOfTeams(8L);
		contest.setStartingDate("2001-01-01");
		contest.setCompletionDate("2002-01-01");
		contest.setUserId(100L);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/contest").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(contest))).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getContest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/contest"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
