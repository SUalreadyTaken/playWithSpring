package com.su.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAscpect {

    @Around("execution(* com.su.aopdemo.dao.AccountDAO.findAccounts*(..))")
    public Object howLongFindAccounts(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("===>>@Around on method " + proceedingJoinPoint.getSignature().toShortString());

        Long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        Long finish = System.currentTimeMillis();

        System.out.println("===>> " + proceedingJoinPoint.getSignature().toShortString() + " took " + ((finish - start)) + " milliseconds ");

        return result;
    }

    @Around("execution(* com.su.aopdemo.dao.AccountDAO.handlingExceptionFindAccounts(..))")
    public Object handelingException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("===>>@Around on method " + proceedingJoinPoint.getSignature().toShortString());

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("===>>Got exception " + e);
            System.out.println("===>>will return a null object (List<Account>)");
        }

        return null;
    }




}
