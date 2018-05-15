<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>


    <title>Taxi</title>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="local" var="loc"/>

    <fmt:message bundle="${loc}" key="local.login" var="login"  />
    <fmt:message bundle="${loc}" key="local.about" var="about"  />
    <fmt:message bundle="${loc}" key="local.services" var="services" />
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"  />
    <fmt:message bundle="${loc}" key="local.home" var="home"  />
    <fmt:message bundle="${loc}" key="local.signup" var="signup"  />
    <fmt:message bundle="${loc}" key="local.orderNow" var="orderNow"  />
    <%@include file="WEB-INF/jsp/partialHeader.jsp"%>
  </head>


  <body class="page1" id="top">
  <div class="main">
  <header>
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

  <div class="slider_wrapper ">
    <div id="camera_wrap" class="">
      <div data-src="images/slide.jpg" ></div>
      <div data-src="images/slide1.jpg" ></div>
      <div data-src="images/slide2.jpg"></div>
    </div>
  </div>
  <div class="container_12">
    <div class="grid_4">
      <div class="banner">
        <div class="maxheight">
          <div class="banner_title">
            <img src="images/icon1.png" alt="">
            <div class="extra_wrapper">Fast&amp;
              <div class="color1">Safe</div>
            </div>
          </div>
          Dorem ipsum dolor sit amet, consectetur adipiscinger elit. In mollis erat mattis neque facilisis, sit ameter ultricies erat rutrum. Cras facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad
          <a href="#" class="fa fa-share-square"></a>
        </div>
      </div>
    </div>
    <div class="grid_4">
      <div class="banner">
        <div class="maxheight">
          <div class="banner_title">
            <img src="images/icon2.png" alt="">
            <div class="extra_wrapper">Best
              <div class="color1">Prices</div>
            </div>
          </div>
          Hem ipsum dolor sit amet, consectetur adipiscinger elit. In mollis erat mattis neque facilisis, sit ameter ultricies erat rutrum. Cras facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuader
          <a href="#" class="fa fa-share-square"></a>
        </div>
      </div>
    </div>
    <div class="grid_4">
      <div class="banner">
        <div class="maxheight">
          <div class="banner_title">
            <img src="images/icon3.png" alt="">
            <div class="extra_wrapper">Package
              <div class="color1">Delivery</div>
            </div>
          </div>
          Kurem ipsum dolor sit amet, consectetur adipiscinger elit. In mollis erat mattis neque facilisis, sit ameter ultricies erat rutrum. Cras facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuki
          <a href="#" class="fa fa-share-square"></a>
        </div>
      </div>
    </div>
    <div class="clear"></div>
  </div>
  <div class="c_phone">
    <div class="container_12">
      <div class="grid_12">
        <div class="fa fa-phone"></div>+ 1800 559 6580
        <span>${orderNow}</span>
      </div>
      <div class="clear"></div>
    </div>
  </div>

  <%--<br>--%>
  <%--<a href="/login">${login}</a>--%>
  <%--<br>--%>
  <%--<a href="/signup">${signup}</a>--%>
  <%--<br>--%>
  <%--<br>--%>
  <%--Join the drivers--%>
  <%--<br>--%>

  <%--<a href="/driversignup">${signup}</a>--%>


</div>
  <footer>
    <div class="container_12">
      <div class="grid_12">
        <div class="f_phone"><span> <%@include file="WEB-INF/jsp/language.jsp"%></span></div>
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
