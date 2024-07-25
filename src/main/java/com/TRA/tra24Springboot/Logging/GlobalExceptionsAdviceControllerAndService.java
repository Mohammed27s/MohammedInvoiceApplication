package com.TRA.tra24Springboot.Logging;


//Global exception handling centralizes error management across the application,
// while custom exception handling allows tailored responses for specific types or contexts of errors.

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


//Introduce Global Exception Handling Advice and relevant pointcut
// definitions to handle and log exceptions in Controllers and Services
@Aspect
@Component
public class GlobalExceptionsAdviceControllerAndService {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionsAdviceControllerAndService.class);

    // Define a pointcut that matches all methods within controllers and services
    @Pointcut("execution(* com.TRA.tra24Springboot.Controllers.*.*(..)) || execution(* com.TRA.tra24Springboot.Services.*.*(..))")
    public void serviceLayerPointcut() {
    }

    @AfterThrowing(pointcut = "serviceLayerPointcut()", throwing = "ex")
    public void handleGlobalException(Exception ex) {
        logger.error("Exception caught in GlobalExceptionHandlingAspect: ", ex);

        if (ex instanceof NullPointerException) {
            handleNullPointerException((NullPointerException) ex);
        } else if (ex instanceof IllegalArgumentException) {
            handleIllegalArgumentException((IllegalArgumentException) ex);
        } else {
            handleGenericException(ex);
        }
    }

    private void handleNullPointerException(NullPointerException ex) {
        logger.error("NullPointerException occurred: ", ex);
    }

    private void handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException occurred: ", ex);
    }

    private void handleGenericException(Exception ex) {
        logger.error("An unexpected exception occurred: ", ex);
    }
}