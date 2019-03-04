package com.su.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class AfterThrowingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.su.aopdemo.dao.AccountDAO.findAccountsException(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAspect(JoinPoint joinPoint, Throwable exception) {
        System.out.println("===>>@AfterThrowing on method " + joinPoint.getSignature().toShortString());
        System.out.println("===>>afterThrowingFindAccountsAspect exception >> " + exception);
    }


}
