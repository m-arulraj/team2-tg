package com.sms.scoreboardapi;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import junit.framework.TestCase;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AppTest 
    extends TestCase
{
	private MockMvc mockmvc;
	@Autowired
	protected WebApplicationContext wac;
	
	@Before(value = "")
    public void setup() throws Exception {
	this.mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
	
	}
	
}
