<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>

</head>

<body>

<!-- When form is leaded Spring MVC will call student.getFirstname() -->
<!-- IntelliJ shows modelAttribute student as error ignore it -->
<form:form action="processForm" modelAttribute="student">
    <!-- path equals method names get/set -->
    First name:
    <form:input path="firstName"/> <br>
    Last name:
    <form:input path="lastName"/> <br>
    Gender:
    <form:select path="gender" >
        <%-- <form:options items="${student.genderOptions}" /> --%>
        <form:options items="${genderOptions}" />
    </form:select>
    Do you:
    <form:checkboxes path="habbits" items="${student.habbitOptions}" />
    <!-- When form is submitted Spring MVC will call student.setFirstName -->
    <input type="submit" value="Submit"/>
</form:form>


</body>


</html>