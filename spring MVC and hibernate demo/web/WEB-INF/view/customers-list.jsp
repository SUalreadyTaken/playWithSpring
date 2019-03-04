<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>List Customers</title>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <input type="button" value="addCustomer" onclick="window.location.href='customerForm'; return false;" />

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tmpCustomer" items="${customers}">
                    <c:url var="updateLink" value="/customer/updateCustomer">
                        <c:param name="customerId" value="${tmpCustomer.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="/customer/deleteCustomer">
                        <c:param name="customerId" value="${tmpCustomer.id}" />
                    </c:url>

                    <tr>
                        <td>${tmpCustomer.firstName}</td>
                        <td>${tmpCustomer.lastName}</td>
                        <td>${tmpCustomer.email}</td>
                        <td><a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer ?'))) return false">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>