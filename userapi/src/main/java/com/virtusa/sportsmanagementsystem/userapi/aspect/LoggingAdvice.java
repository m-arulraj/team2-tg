package com.virtusa.sportsmanagementsystem.userapi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	
	private static Logger logger= Logger.getLogger(LoggingAdvice.class);  

	//@Around("execution(com.sms.scoreboardapi.resource.*.*(..))")
	//@Before("execution(*com.sms.scoreboardapi.resource.*.*(..))")
	@Around("execution(* com.sms.scoreboardapi.*.*.*(..))")
	public Object log(ProceedingJoinPoint pjp)throws Throwable{
		
		logger.info("entering into :: "+pjp.getSignature());
		long startTime=System.currentTimeMillis();
		Object returnValue= pjp.proceed();
		long endTime=System.currentTimeMillis();
		long time=endTime-startTime;
		logger.info("the method "+pjp.getSignature()+" has taken "+time+" milliseconds of time");
		logger.info("leaving :: "+pjp.getSignature());
		return returnValue;
	}
	
}
