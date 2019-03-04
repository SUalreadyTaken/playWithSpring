package com.su.aopdemo.aspect;


import com.su.aopdemo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class AfterReturningAspect {

    @AfterReturning(
            pointcut = "execution(* com.su.aopdemo.dao.AccountDAO.findAccounts*(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("===>>@AfterReturning on method: " + joinPoint.getSignature().toShortString());
        System.out.println("===>>afterReturningFindAccountsAdvice >> changing account name to uppercase  " + result);

        // modify data before it makes back to calling program
        result.forEach(a -> a.setName(a.getName().toUpperCase()));

    }



}
