<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.about" var="about"/>
    <fmt:message bundle="${loc}" key="local.services" var="services"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.home" var="home"/>
    <%@include file="partialHeader.jsp"%>

    <script>
        function check_status() {
            $.ajax({
                url: 'FrontController?command=CHECK_STATUS',
                success: function () {
                   alert("ok");
                },
                error: function () {
                    alert('error');
                }
            });
        }
    </script>
</head>
<body class="" id="top">
<header >
    <div class="menu_block ">
        <div class="container_12">
            <div class="grid_12">
                <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                    <ul class="sf-menu">
                        <li class="current"><a href="/index">${home}</a></li>
                        <li><a href="/about">${about}</a></li>
                        <li><a href="/services">${services}</a></li>
                        <li><a href="/contacts">${contacts}</a></li>
                        <li><a href="/login">${login}</a></li>

                    </ul>
                </nav>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="container_12">
        <div class="grid_12">
            <h1>
                <a href="/index">
                    <img src="images/logo.png" alt="Your Happy Family">
                </a>
            </h1>
        </div>
    </div>
    <div class="clear"></div>
</header>



Order status: <c:if test="${not empty message}">
    <div class="alert alert-success">
            ${message}
    </div>
</c:if>

<br>
<a href="FrontController?command=CHECK_STATUS" >Check order status</a>
<br>
<a href="FrontController?command=DECLINE_ORDER">Cancel order</a>


</body>
</html>
