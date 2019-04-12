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
public class UserServiceTest {
	@Autowired
	WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void userRegistrationTest() throws Exception {
		User user = new User();
		user.setUserName("Srinivas");
		user.setAddress("Banglore");
		user.setEmail("Srinivas@gmail.com");
		user.setMobileNumber(121351235L);
		user.setPassword("sri");
		user.setUserDob("12-12-2011");
		user.setEnabled(1);
		UserRole userrole = new UserRole();
		userrole.setId(4);
		userrole.setRole("ROLE_CONTEST_OWNER");
		userrole.setUser(user);
		 ResultActions result =mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userrole)) );
		result.andExpect(MockMvcResultMatchers.status().isCreated());
		
	}
	
	@Test
	public void deleteUser() throws Exception {
		int id =50;
		ResultActions result=mockMvc.perform(MockMvcRequestBuilders.delete("/api/user?id=50").contentType(MediaType.APPLICATION_JSON));
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	
	  @Test 
	  public void updateUser() throws Exception {
		  User user = new User();
			user.setUserName("sri");
			user.setAddress("Vijayawada");
			user.setEmail("hima@gmail.com");
			user.setMobileNumber(121355L);
			user.setPassword("hima");
			user.setUserDob("12-12-2011");
			user.setEnabled(1);
		  ResultActions result=mockMvc.perform(MockMvcRequestBuilders.put("/api/user?id=51")
				  .contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(user)));
			result.andExpect(MockMvcResultMatchers.status().isOk());
	  }
	  @Test
		public void getUser() throws Exception {
			
			ResultActions result=mockMvc.perform(MockMvcRequestBuilders.get("/api/user?username=himasri@gmail.com").contentType(MediaType.APPLICATION_JSON));
			result.andExpect(MockMvcResultMatchers.status().isOk());
		}
		
	  @Test
	  public void getUserRole() throws Exception {
		  ResultActions result=mockMvc.perform(MockMvcRequestBuilders.get("/api/user/userrole?username=himasri@gmail.com").contentType(MediaType.APPLICATION_JSON));
			result.andExpect(MockMvcResultMatchers.status().isOk());
	  }
	  
	 
	  
}
