<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<html>
<body>
<p>User: <security:authentication property="principal.username" /></p>
<p>Role: <security:authentication property="principal.authorities" /> </p>
<p>Home.jsp :) for real</p>

<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/manager"> Manager page </a> (Manager/admin)
    </p>
</security:authorize>
<security:authorize access="hasRole('ADMIN')" >
    <p>
        <a href="${pageContext.request.contextPath}/admin"> Admin page </a> (Admin)
    </p>
</security:authorize>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout" />
</form:form>

</body>
</html>