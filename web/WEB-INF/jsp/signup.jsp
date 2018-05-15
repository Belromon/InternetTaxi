<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

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
    <input type="hidden" name="command" value="REGISTRATION">
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

    <input type="submit" value="${submit}">
</form>

</div>

<footer>
    <div class="container_12">
        <div class="grid_12">
            <div class="f_phone"><span> <%@include file="language.jsp"%></span></div>
            <div class="socials">
                <a href="#" class="fa fa-twitter"></a>
                <a href="#" class="fa fa-facebook"></a>
                <a href="#" class="fa fa-google-plus"></a>
            </div>
            <div class="copy">
                <div class="st1">
                    <div class="brand">Tour<span class="color1">T</span>axi </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</footer>
</body>
</html>
