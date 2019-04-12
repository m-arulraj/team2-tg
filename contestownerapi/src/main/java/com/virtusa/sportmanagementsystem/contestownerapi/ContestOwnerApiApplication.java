package com.virtusa.sportmanagementsystem.contestownerapi;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContestOwnerApiApplication 
{
    public static void main( String[] args )
    {
    	Logger logger = Logger.getLogger(ContestOwnerApiApplication.class);
    	PropertyConfigurator.configure("src/main/resources/log4j.properties");
    	logger.info("Application is Starting");
        SpringApplication.run(ContestOwnerApiApplication.class, args);
        
    }
}
