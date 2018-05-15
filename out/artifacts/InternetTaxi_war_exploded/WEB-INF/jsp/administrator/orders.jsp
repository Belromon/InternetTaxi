<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<c:choose>
    <c:when test="${not empty orders}">
        <table class="table table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Start </td>
                <td>End</td>
                <td>Status</td>
                <td>id customer</td>
                <td>id driver</td>
            </tr>
            </thead>
            <c:forEach var="orders" items="${orders}">
                <tr>
                    <td>${orders.id}</td>
                    <td>${orders.from}</td>
                    <td>${orders.destination}</td>
                    <td>${orders.status}</td>
                    <td>${orders.id_customer}</td>
                    <td>${orders.id_driver}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>

</c:choose>

</body>
</html>
