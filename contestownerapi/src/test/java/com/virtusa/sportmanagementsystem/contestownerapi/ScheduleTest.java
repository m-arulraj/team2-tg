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
import com.virtusa.sportmanagementsystem.contestownerapi.domain.Schedule;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScheduleTest {

	@Autowired
	WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void addScheduleTest() throws Exception {
		Schedule schedule = new Schedule();
		schedule.setVenue("Chennai");
		schedule.setMatchDate("01/02/2001");
		schedule.setContestId(119L);
		schedule.setTeamOne(84L);
		schedule.setTeamTwo(113L);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/schedule/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(schedule)))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void addScheduleWithoutVenueTest() throws Exception {
		Schedule schedule = new Schedule();
		schedule.setMatchDate("01/02/2001");
		schedule.setContestId(119L);
		schedule.setTeamOne(84L);
		schedule.setTeamTwo(113L);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/schedule/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(schedule)))
		.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void addScheduleWithWrongVenueNameTest() throws Exception {
		Schedule schedule = new Schedule();
		schedule.setVenue("Chennai200");
		schedule.setMatchDate("01/02/2001");
		schedule.setContestId(119L);
		schedule.setTeamOne(84L);
		schedule.setTeamTwo(113L);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/schedule/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(schedule)))
		.andExpect(MockMvcResultMatchers.status().is(422));
	}
	
	@Test
	public void updateScheduleTest() throws Exception {
		Schedule schedule = new Schedule();
		schedule.setId(129L);
		schedule.setVenue("Mumbai");
		schedule.setMatchDate("2001-02-01");
		schedule.setContestId(119L);
		schedule.setTeamOne(84L);
		schedule.setTeamTwo(113L);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/schedule").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(schedule))).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getSchedule() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/schedule"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
