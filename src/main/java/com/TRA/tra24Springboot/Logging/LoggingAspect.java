package com.TRA.tra24Springboot.Logging;



//This is Aspect-oriented programming(AOP) : this is used for  modularize cross-cutting concerns in software systems,
// such as logging, security, transaction management, and error handling.

//for the task we have to use before and after
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;


//This is code must be change with contollers that are existing in this spring boot project
@Aspect
@Component
public class LoggingAspect {

    public static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Pointcut(value = "execution(* com.tra.school.Controllers.SchoolController.*(..))")
    public void pointCutDefinitionSchool() {
    }

    @Before(value = "pointCutDefinitionSchool()")
    public void logBefore(JoinPoint pjp) {
        System.out.println("Before method: " + pjp.getSignature().getName());
    }

    @AfterReturning(value = "pointCutDefinitionSchool()", returning = "result")
    public void logAfterReturning(JoinPoint pjp, Object result) {
        System.out.println("After method: " + pjp.getSignature().getName() + ", Result: " + result);
    }

    @Around(value = "pointCutDefinitionSchool()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();

        logger.info("\n***** Before function execution ****"+"\nThis class is running: " + className + "\nThis function is running " + methodName + "() " + "\nFunction arguments : "
                + mapper.writeValueAsString(array));

        Object object = pjp.proceed();

        logger.info("\n**** After function execution ****"+ "\nThis class is running: " + className + "\nThis function is running " + methodName + "()" + "\nResponse : "
                + mapper.writeValueAsString(object));
        return object;
    }


}
