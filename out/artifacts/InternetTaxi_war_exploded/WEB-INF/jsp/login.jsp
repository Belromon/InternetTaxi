<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.signin" var="signin"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.submit" var="submit"/>
    <fmt:message bundle="${loc}" key="local.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.about" var="about"/>
    <fmt:message bundle="${loc}" key="local.services" var="services"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.home" var="home"/>
    <fmt:message bundle="${loc}" key="local.signup" var="signup"/>
    <fmt:message bundle="${loc}" key="local.orderNow" var="orderNow"/>
    <title>LogIn</title>
    <%@include file="partialHeader.jsp" %>
    <link rel="stylesheet" href="css/auth-style.css" media="screen" type="text/css"/>


</head>
<body id="top">
<div class="main">
    <header>
        <div class="menu_block ">
            <div class="container_12">
                <div class="grid_12">
                    <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                        <ul class="sf-menu">
                            <li><a href="/index">${home}</a></li>
                            <li><a href="/about">${about}</a></li>
                            <li><a href="/services">${services}</a></li>
                            <li><a href="/contacts">${contacts}</a></li>
                            <li class="current"><a href="/login">${login}</a></li>

                        </ul>
                    </nav>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

    </header>

    <div class="content">
        <div id="login">
            <h3 style="font-size: 38px;margin-bottom: 35px;margin-left: 120px;">Log In</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="AUTHENTICATION">

                <form action="javascript:void(0);" method="get">
                    <fieldset class="clearfix">
                        <p><span class="fontawesome-user"></span><input type="text" name="login" value="${signin}"
                                                                        onBlur="if(this.value == '') this.value = '${signin}'"
                                                                        onFocus="if(this.value == '${signin}') this.value = ''"
                                                                        required></p>
                        <p><span class="fontawesome-lock"></span><input type="password" name="password"
                                                                        value="${password}"
                                                                        onBlur="if(this.value == '') this.value = '${password}'"
                                                                        onFocus="if(this.value == '${password}') this.value = ''"
                                                                        required></p>
                        <input type="submit" value="Отправить" style="margin-left: 75px; margin-top: 10px;">
                    </fieldset>
                </form>
                <p>Нет аккаунта? &nbsp;&nbsp;<a href="/signup">Регистрация</a><span
                        class="fontawesome-arrow-right"></span>
                </p>

                <p>Хотите стать водителем? &nbsp;&nbsp;<a href="/driversignup">Вперед!</a><span
                        class="fontawesome-arrow-right"></span>
                </p>


            </form>
        </div>
    </div>
</div>

<footer>
    <div class="container_12">
        <div class="grid_12">
            <div class="f_phone"><span> <%@include file="language.jsp" %></span></div>
            <div class="socials">
                <a href="#" class="fa fa-twitter"></a>
                <a href="#" class="fa fa-facebook"></a>
                <a href="#" class="fa fa-google-plus"></a>
            </div>
            <div class="copy">
                <div class="st1">
                    <div class="brand">Tour<span class="color1">T</span>axi</div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</footer>

</body>
</html>
