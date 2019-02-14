<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>

</head>
    <style>
        .error {color:red}
    </style>
<body>

<!-- When form is leaded Spring MVC will call customer.getFirstname() -->
<!-- IntelliJ shows modelAttribute student as error ignore it -->
<form:form action="processForm" modelAttribute="customer">
    <!-- path equals method names get/set -->
    First name:
    <form:input path="firstName"/> <br>
    Last name (*):
    <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error" /> <br>
    Age (*)
    <form:input path="age" />
    <form:errors path="age" cssClass="error" /> <br>
    Postal code:
    <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error" /> <br>
    Course code(*):
    <form:input path="courseCode" />
    <form:errors path="courseCode" cssClass="error" /> <br>    <br>
    <input type="submit" value="Submit"/>
</form:form>


</body>


</html>