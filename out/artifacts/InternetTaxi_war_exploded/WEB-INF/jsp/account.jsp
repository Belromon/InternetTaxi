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


    <title>Account</title>
    <%@include file="partialHeader.jsp" %>

    <style>
        .grid-container {
            display: grid;
            grid-template-columns: auto auto auto auto auto auto;
            grid-gap: 10px;
            padding: 10px;
        }
        .grid-container > div {
            background-color: #fdc903;
            text-align: center;
            padding: 20px 0;
            font-size: 15px;
        }
        .item1 {
            grid-row: 1 / 4;
        }
    </style>
</head>
<body class="page1" id="top">



<c:choose>
    <c:when test="${role eq 'customer'}">
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
                                <li class="current"><a href="/FrontController?command=LOGOUT">Log Out</a></li>

                            </ul>
                        </nav>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>

        </header>

        Welcome <c:out value="${sessionScope.role}"/>, it yours account!
        <br>
        Your name <c:out value="${sessionScope.user.name}"/>
        <br>
        Your surname <c:out value="${sessionScope.user.surname}"/>
        <br>
        Your login <c:out value="${sessionScope.user.login}"/>
        <br>
        <br>

        <a href="/edit">Edit account</a>
        <br>
        <a href="/FrontController?command=DELETE_ACCOUNT">DELETE</a>
        <br>
        <a href="/FrontController?command=CHECK_ACTIVER_CUSTOMER_ORDER">Go to the main page</a>



    </c:when>


    <c:when test="${role eq 'driver'}">
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
                                <li class="current"><a href="/FrontController?command=LOGOUT">Log Out</a></li>

                            </ul>
                        </nav>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>

        </header>

        <div class="grid-container">
            <div class="item1">
                Welcome to the <c:out value="${sessionScope.role}"/>
                <br>
                Your name <c:out value="${sessionScope.user.name}"/>
                <br>
                Your surname <c:out value="${sessionScope.user.surname}"/>
                <br>
                Your login <c:out value="${sessionScope.user.login}"/>
                <br>
                <br>
                <a href="/edit">Edit account</a>
                <br>
                <a href="/FrontController?command=DELETE_ACCOUNT">DELETE</a>
                <br>



            </div>
            <div class="item2">
                <c:if test="${sessionScope.user.confirmed ==true}">

                    <a href="/FrontController?command=CHOOSE_ORDER">Go to ORDERS!</a>
                </c:if>
            </div>
            <div class="item3"><c:if test="${sessionScope.user.confirmed ==false}">
                You have not been confirmed by Administrator
                and can not work yet

            </c:if></div>

        </div>

    </c:when>

    <c:when test="${role eq 'admin'}">
        <header>
            <div class="menu_block ">
                <div class="container_12">
                    <div class="grid_12">
                        <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                            <ul class="sf-menu">
                                <li><a href="FrontController?command=SHOW_ALL_DRIVERS">Drivers</a></li>
                                <li><a href="FrontController?command=SHOW_ALL_USERS">Users</a></li>
                                <li><a href="FrontController?command=SHOW_ALL_ADMINS">Admins</a></li>
                                <li><a href="FrontController?command=SHOW_ALL_ORDERS">Orders</a></li>
                                <li class="current"><a href="/FrontController?command=LOGOUT">Log Out</a></li>

                            </ul>
                        </nav>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>

        </header>

        <div align="center">

            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="ADMIN_REGISTRATION">
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
    </c:when>


</c:choose>


</body>
</html>