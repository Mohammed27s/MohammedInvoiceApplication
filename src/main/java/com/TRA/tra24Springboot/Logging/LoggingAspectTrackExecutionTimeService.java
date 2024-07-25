package com.TRA.tra24Springboot.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


//Introduce Logging Advice and
// relevant pointcut definitions to track execution time of Services
@Component
@Aspect
public class LoggingAspectTrackExecutionTimeService {


    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectTrackExecutionTimeService.class);

    @Pointcut("execution(* com.TRA.tra24Springboot.Services.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Before {}.{}() with arguments {}", className, methodName, args);
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturningFromService(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        logger.info("After {}.{}() returned {}", className, methodName, result);
    }

    @Around("serviceMethods()")
    public Object logServiceMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Executing {}.{}() with arguments {}", className, methodName, args);

        Object result = joinPoint.proceed();

        long elapsedTime = System.currentTimeMillis() - startTime;

        logger.info("{}.{}() executed in {} ms", className, methodName, elapsedTime);

        return result;
    }




}
