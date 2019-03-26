Do not use the src/main/webapp directory if your application is packaged as a JAR.  
Although this is a standard Maven directory, it works only with WAR packaging.  
It is silently ignored by most build tools if you generate a JAR.  
___
Version 1: Use EntityManager but leverage native Hibernate API  
Version 2: Use EntityManager and standard JPA API  
Version 3: Spring Data JPA  
___
If 2 beans with the same name use @Qualifier("beanName") to specify which one to use
___
By default Spring Data REST will create endpoints based on entity type  
Simple pluralized form. First character of Entity type is lowercase and then just adds "s" to the entity.  
```java
public interface EmployeeRepository extends JpaRepositoryEmployee, Integer> {} 
```  
will create endpoints /employees  
localhost:8080/employees  
___
To change the endpoint to workers
```java
@RepositoryRestResource(path="workers")
public interface EmployeeRepository extends JpaRepositoryEmployee, Integer> {}
```

___
For Spring Data REST you only need 3 items  
1. Entity
2. JpaRepository
3. Maven POM dependency for spring-boot-starter-data-rest
___
To set "request mapping" go to application.properties and use spring.data.rest.base-path=/someName