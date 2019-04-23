package com.virtusa.sportmanagementsystem.contestownerapi;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableAspectJAutoProxy
@EnableEurekaClient
@EnableFeignClients
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
