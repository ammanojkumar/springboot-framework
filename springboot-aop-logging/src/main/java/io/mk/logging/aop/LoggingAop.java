package io.mk.logging.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class LoggingAop {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* io.mk.logging.controller..*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info(" Allowed execution for {}", joinPoint);
	}

	@Around("execution(* io.mk.logging.controller..*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object object = joinPoint.proceed();
		stopWatch.stop();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {} ms", joinPoint, timeTaken);

		return object;
	}

	@AfterReturning(value = "execution(* io.mk.logging.controller..*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}

	@After(value = "execution(* io.mk.logging.controller..*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}

}
