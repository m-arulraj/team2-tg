package com.virtusa.sportsmanagementsystem.teammanagerapi;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableAspectJAutoProxy
public class TeamManagementApplication 
{
	private static Logger logger = Logger.getLogger(TeamManagementApplication.class.getClass());
    public static void main( String[] args )
    {
    	PropertyConfigurator.configure("src/main/resources/log4j.properties");
    	logger.info("Team Management Application is started");
        SpringApplication.run(TeamManagementApplication.class, args);
    }
}
