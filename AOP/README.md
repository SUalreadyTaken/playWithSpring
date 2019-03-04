execution(modifiers-pattern? return-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)  

? - is optional  
modifier - public, private..  
declaring - void, String, foo..  
star(*) - wildcard, matches anything   

example.. @Before("execution(* add*()) )"

param-pattern  
() - matches a method with no arguments  
(*) - matches a method with one argument of any type  
(..) - matches a method with 0 or more arguments of any type  

Match any method in a package  
```java
@Before("execution(* com.su.aopdemo.dao.*.*(..))")
```

reusable pointcut expression  
```java  
@Pointcut("execution(public void com.su.aopdemo.dao.AccountDAO.addAccount())")  
private void accountDAOAddAccount() {}
 
@Before("accountDAOAddAccount()")  
public void beforeAddAccountAdvice() {  
        System.out.println(">>@Before advice on (public void com.su.aopdemo.dao.AccountDAO.addAccount())");
    }
```

if you want to use public pointcut expressions you need to give full class name
@Before("com.su.aopdemo.aspect.PointcutExpression.daoPackageNoGetterSetter()")


@After will run before @AfterThrowing