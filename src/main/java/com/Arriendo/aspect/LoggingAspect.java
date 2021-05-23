package com.Arriendo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());
	
    //	for all method of controller pkg
	@Pointcut("execution(* com.Arriendo.Controller.*.*(..))")
	private void forController() {}

    //	for all method of service pkg
	@Pointcut("execution(* com.Arriendo.service.*.*(..))")
	private void forService() {}

    //	for all method of dao pkg
	@Pointcut("execution(* com.Arriendo.dao.*.*(..))")
	private void forDao() {}
	
	// combining all ponitcut expression
	@Pointcut("forController() || forService() || forDao()")
	private void forControllerServiceDao() {}
	
	@Before("forControllerServiceDao()")
	public void beforeAdvice(JoinPoint joinPoint) {
		// display method which is about to call
		logger.info("Before method ======>> "+joinPoint.getSignature());
		
		// get the arg
		Object[] args = joinPoint.getArgs();
				
		// display arg		
		for(Object arg:args) {
			logger.info("Before method argument======>> "+arg);
		}
	}

	@AfterReturning(pointcut = "forControllerServiceDao()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		// display method we are returning from
		logger.info("AfterReturning from method ======>> "+joinPoint.getSignature());
		
		// display data returned
		logger.info("AfterReturning from method data returned is ======>> "+result);
	}
}
