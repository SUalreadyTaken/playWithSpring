package com.su.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspect {

    @After("execution(* com.su.aopdemo.dao.AccountDAO.findAccounts*(..))")
    public void afterFindAccountsException(JoinPoint joinPoint) {
        System.out.println("===>>@After on method " + joinPoint.getSignature().toShortString());
    }

}
