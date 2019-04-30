package com.virtusa.sportsmanagementsystem.userapi;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableAspectJAutoProxy
public class UserServiceApplication 
{
	 private static Logger logger= null;
    public static void main( String[] args )
    {
    	
    	logger = Logger.getLogger(UserServiceApplication.class.getName());
    	PropertyConfigurator.configure("src/main/resources/log4j.properties");
      SpringApplication.run(UserServiceApplication.class, args);
      
    }
}
