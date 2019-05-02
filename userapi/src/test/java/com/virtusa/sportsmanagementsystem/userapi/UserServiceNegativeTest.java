package com.virtusa.sportsmanagementsystem.userapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.google.gson.Gson;
import com.virtusa.sportsmanagementsystem.userapi.domain.User;
import com.virtusa.sportsmanagementsystem.userapi.domain.UserRole;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceNegativeTest {
	@Autowired
	WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void userRegistrationNegativeTest() throws Exception {
		User user = new User();
		user.setUserName("Himasri");
		user.setAddress("Vijayawada");
		user.setEmail("hima@gmail.com");
		user.setMobileNumber(121355L);
		user.setPassword("hima");
		user.setUserDob("12-12-2011");
		user.setEnabled(1);
		UserRole userrole = new UserRole();
		userrole.setId(3);
		userrole.setAuthority("ScoreboardManager");
		userrole.setUser(user);
		 ResultActions result =mockMvc.perform(MockMvcRequestBuilders.post("/api/user") 
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userrole)) );
		result.andExpect(MockMvcResultMatchers.status().isConflict()).andDo(MockMvcResultHandlers.print());
		
	}
	@Test
	public void userRegistrationNegativeTestwithEmptyUserName() throws Exception {
		User user = new User();
		user.setUserName("");
		user.setAddress("Vijayawada");
		user.setEmail("hima@gmail.com");
		user.setMobileNumber(1213557890L);
		user.setPassword("himasri");
		user.setUserDob("12-12-2011");
		user.setEnabled(1);
		UserRole userrole = new UserRole();
		userrole.setId(3);
		userrole.setAuthority("ScoreboardManager");
		userrole.setUser(user);
		 ResultActions result =mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userrole)) );
		result.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andDo(MockMvcResultHandlers.print());
		
	}
	@Test
	public void userRegistrationNegativeTestwithemail() throws Exception {
		User user = new User();
		user.setUserName("dcvxc");
		user.setAddress("Vijayawada");
		user.setEmail("higc@");
		user.setMobileNumber(1213557890L);
		user.setPassword("himasri");
		user.setUserDob("12-12-2011");
		user.setEnabled(1);
		UserRole userrole = new UserRole();
		userrole.setId(3);
		userrole.setAuthority("ScoreboardManager");
		userrole.setUser(user);
		 ResultActions result =mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userrole)) );
		result.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andDo(MockMvcResultHandlers.print());
		
	}
	
}
