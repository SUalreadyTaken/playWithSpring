package com.su.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class RandomBeforeAscpet {
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice2() {
        System.out.println("===>>@Before advice on (public void addAccount())");
    }

    @Before("execution(public void add*())")
    public void wildCard() {
        System.out.println("===>>@Before advice on (public void add*())");
    }

    @Before("execution(String add*())")
    public void wildCardString() {
        System.out.println("===>>@Before advice on (String add*())");
    }

    @Before("execution(* add*(com.su.aopdemo.model.Account, ..))")
    public void addAccountForReal() {
        System.out.println("===>>@Before advice on (* add*(com.su.aopdemo.model.Account, ..))");
    }

    @Before("execution(* com.su.aopdemo.dao.*.*(..))")
    public void anyMethodInPackage() {
        System.out.println("===>>@Before advice on (* com.su.aopdemo.dao.*.*(..))");
    }

}
