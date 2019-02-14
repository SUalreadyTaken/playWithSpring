@ModelAttribute  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  

model databinding  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
forEach

........

When performing Spring MVC validation, the **location** of the BindingResult parameter is very important. In the method signature, the BindingResult parameter must immediately after the model attribute.   
i.e. (@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {  
@InitBinder  
Pre-process data

........

To check NotNull on integer field use **Integer** not **int** so it can handle "null" and not give you cant convert String to int error

........

Custom error message  
Load custom error message from src/resources/messages.properties  
get codes from **BindingResult** with sys out so you can specify what message to display on what error    
i.e. codes [typeMismatch.customer.age,typeMismatch.age,typeMismatch.java.lang.Integer,typeMismatch]  

........

Custom annotation and validator for validating a field  

@Constraint(validatedBy = CourseCodeConstraintValidator.class)  
@Target( {ElementType.METHOD, ElementType.FIELD})  
@Retention(RetentionPolicy.RUNTIME)  
public @interface CourseCode {   

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {


........