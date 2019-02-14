<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>

</head>

<body>

Welcome ${student.firstName} ${student.lastName} and your gender is ${student.gender} <br>
Habits are >> <c:forEach var="temp" items="${student.habbits}" > ${temp} | </c:forEach>


</body>


</html>