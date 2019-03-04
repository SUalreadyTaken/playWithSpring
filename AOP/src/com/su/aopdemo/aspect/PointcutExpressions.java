package com.su.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {

    // reusable pointcut expression
    @Pointcut("execution(public void com.su.aopdemo.dao.AccountDAO.addAccount())")
    public void accountDAOAddAccount() {}

    @Pointcut("execution(* com.su.aopdemo.dao.*.*(..))")
    public void daoPackage() {}

    @Pointcut("execution(* com.su.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.su.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("daoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter() {}

    @Before("daoPackageNoGetterSetter()")
    public void daoPackageExcludeGetterSetter() {
        System.out.println("===>>@Before on daoPackage methods excluding getter and setter");
    }


}
