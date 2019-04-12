package com.sms.scoreboardapi;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ScoreBoardApiApplication {

	public static void main(String[] a) {
		Logger logger=Logger.getLogger(ScoreBoardApiApplication.class);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.info("starting scoreBoard Api");
		SpringApplication.run(ScoreBoardApiApplication.class, a);
	}
}
