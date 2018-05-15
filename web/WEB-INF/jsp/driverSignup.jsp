<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.login" var="login"  />

    <fmt:message bundle="${loc}" key="local.name" var="name"  />
    <fmt:message bundle="${loc}" key="local.surname" var="surname"  />
    <fmt:message bundle="${loc}" key="local.password" var="password"  />
    <fmt:message bundle="${loc}" key="local.submit" var="submit"/>
    <fmt:message bundle="${loc}" key="local.about" var="about"/>
    <fmt:message bundle="${loc}" key="local.services" var="services"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.home" var="home"/>
    <fmt:message bundle="${loc}" key="local.car_model" var="car_model"/>
    <fmt:message bundle="${loc}" key="local.car_number" var="car_number"/>
    <%@include file="partialHeader.jsp"%>



</head>
<body class="" id="top">
<div class="main">
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
<form action="FrontController" method="post">
    <input type="hidden" name="command" value="DRIVER_REGISTRATION"/>
    ${name}:<br />
    <input type="text" name="name" value="">
    <br/>
    ${surname}:<br />
    <input type="text" name="surname" value="">
    <br />
    ${login}:<br />
    <input type="text" name="login" value="">
    <br>
    ${password}:<br>

    <input type="password" name="password" value="">
    <br>
    ${car_model}:<br>

    <input type="text" name="car_model" value="">
    <br>
    ${car_number}:<br>

    <input type="text" name="car_number" value="">
    <br>

    <input type="submit" value="${submit}">
</form>


</div>

<div>
    <%@include file="language.jsp"%>
</div>


</body>
</html>
