<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

    <h3>My login page</h3>
    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
        <c:if test="${param.error != null}">
            <i class="error">Invalid credentials</i>
        </c:if>
        <c:if test="${param.logout != null}">
            <i>You have been logged out</i>
        </c:if>
        <p>Username: <input type="text" name="username" /></p>
        <p>Password: <input type="password" name="password" /></p>
        <input type="submit" value="Login">
    </form:form>



</body>
</html>