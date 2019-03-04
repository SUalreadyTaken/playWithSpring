package com.su.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.su.spring.controller.*.*(..))")
    private void controllerPackage() {}

    @Pointcut("execution(* com.su.spring.dao.*.*(..))")
    private void daoPackage() {}

    @Pointcut("execution(* com.su.spring.service.*.*(..))")
    private void servicePackage() {}

    @Pointcut("controllerPackage() || daoPackage() || servicePackage()")
    private void appFlow() {}

    @Before("appFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info("===>>@Before on method " + joinPoint.getSignature().toShortString());

        for (Object o : joinPoint.getArgs()) {
            logger.info("===>Arguments > " + o);
        }
    }

    @AfterReturning(
            pointcut="appFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("===>>@AfterReturning on method " + joinPoint.getSignature().toShortString());
        logger.info("===>>returning > " + result);
    }
}
