package com.TRA.tra24Springboot.Logging;


//Global exception handling centralizes error management across the application,
// while custom exception handling allows tailored responses for specific types or contexts of errors.

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.logging.*;

@Aspect
@Component
public class GlobalExceptionsAdvice {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionsAdvice.class);

    @Pointcut("execution(* com.TRA.tra24Springboot.Services.*.*(..))") //This is applied for all services for Exception Handling
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