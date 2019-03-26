
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/test/hello">Hello ... </a>
<br>
<a href="${pageContext.request.contextPath}/api/students">getStudents </a>
<br>
<a href="${pageContext.request.contextPath}/api/students/0">getStudent </a>
<br>
<a href="${pageContext.request.contextPath}/api/students/999">getStudent999 exception.. </a>



</body>
</html>
