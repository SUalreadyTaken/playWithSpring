<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/testCss.css">
    <script src="${pageContext.request.contextPath}/resources/js/testJS.js"></script>
</head>
<body>
    <h2>Spring MVC Demo - Home page</h2>


    <hr>

    <a href="helloworld/showForm">Hello world form</a>
    <br>
    <a href="student/showForm">Student binding form</a>
    <br>
    <a href="customer/showForm">Customer validation form</a>
    <p>$'{pageContext.request.contextPath} < --- get the right path... remove ' </p>
    <input type="button" onclick="showAlert()" value="Show alert" />
    </body>
</html>