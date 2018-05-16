<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.about" var="about"/>
    <fmt:message bundle="${loc}" key="local.services" var="services"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.home" var="home"/>
    <%@include file="partialHeader.jsp" %>

    <script>
        function accept_order(id) {
            $.ajax({
                url: 'FrontController?command=ACCEPT_ORDER&id=' + id,
                success: function () {
                    $("#" + id).find(".statusTd").text("ACCEPTED");
                },
                error: function () {
                    alert('error');
                }
            });
        }

        function set_on_route_order(id) {
            $.ajax({
                url: 'FrontController?command=ON_ROUTE_ORDER&id=' + id,
                success: function () {
                    $("#" + id).find(".statusTd").text("ON_ROUTE");
                },
                error: function () {
                    alert('error');
                }
            });
        }

        function finish_order(id) {
            $.ajax({
                url: 'FrontController?command=FINISH_ORDER&id=' + id,
                success: function () {
                    $("#" + id).find(".statusTd").text("FINISHED");
                },
                error: function () {
                    alert('error');
                }
            });
        }
    </script>
</head>
<body class="page1" id="top">
<br>

<c:choose>
    <c:when test="${not empty orderList}">
        <table class="table table-striped" id="table">
            <thead>
            <tr>
                <td>ID</td>
                <td>Departure point</td>
                <td>Destination</td>
                <td>STATUS</td>
                <td></td>
                <td></td>

            </tr>
            </thead>
            <c:forEach var="orders" items="${orderList}">
                <tr id="${orders.id}">
                    <td>${orders.id}</td>
                    <td>${orders.from}</td>
                    <td>${orders.destination}</td>
                    <td class="statusTd">${orders.status}</td>
                    <td><a href="#" id="confirm"
                           onclick="accept_order(${orders.id})">
                        <span class="glyphicon glyphicon-ok"/>
                    </a>
                    </td>
                    <td>
                        <a href="#" id="on_route"
                           onclick="set_on_route_order(${orders.id})">
                            <span class="glyphicon glyphicon-plane"/>
                        </a>
                    </td>
                    <td>
                        <a href="#" id="finish"
                           onclick="finish_order(${orders.id})">
                            <span class="glyphicon glyphicon-flag"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <br>
        <div class="alert alert-info">
            There are no orders
        </div>
    </c:otherwise>

</c:choose>

</body>
</html>


