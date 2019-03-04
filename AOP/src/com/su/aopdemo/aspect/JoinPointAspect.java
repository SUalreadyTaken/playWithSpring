package com.su.aopdemo.aspect;

import com.su.aopdemo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class JoinPointAspect {

    @Before("com.su.aopdemo.aspect.PointcutExpressions.daoPackage()")
    public void randomLogging(JoinPoint joinPoint) {
        System.out.println("===>>@Before JoinPoinAspect.. randomLogging");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("===>>joinpoint methodSignature >> " + methodSignature);

        for(Object o : joinPoint.getArgs()) {
            if (o instanceof Account) {
                Account account = (Account) o;
                System.out.println("===>>getting account name in randomLogging from joinPoint >> " + account.getName());
            }

        }
    }


}
