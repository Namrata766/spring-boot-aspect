package com.namrata;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("@annotation(Loggable)")
	public void executeLogging() {}

	@Before("executeLogging()")
	public void logMethodCall(JoinPoint joinPoint) {

		StringBuilder message = new StringBuilder("  Logging from - ")
				.append(joinPoint.getSignature().getDeclaringTypeName())
				.append(" : ").append(joinPoint.getSignature().getName())
				.append(" : ");

		Object[] args = joinPoint.getArgs();

		if(args != null && args.length > 0) {

			message.append("Parameters : [");
			Arrays.asList(args).forEach(a -> 
			message.append(a)
					);

			message.append(" ]");
		}
		
		LOGGER.info(message.toString());
	}
}
