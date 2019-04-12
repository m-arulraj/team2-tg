package com.sms.scoreboardapi.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	
	private static Logger logger= Logger.getLogger(LoggingAdvice.class);  

	@Around("execution(* com.sms.scoreboardapi.resource.ScoreBoardResource.*())")
	public Object log(ProceedingJoinPoint pjp)throws Throwable{
		
		logger.info("entering into :: "+pjp.getSignature());
		Object returnValue= pjp.proceed();
		logger.debug("leaving :: "+pjp.getSignature());
		return returnValue;
	}
	
}
