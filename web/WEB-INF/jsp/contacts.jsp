<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Contacts</title>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.about" var="about"/>
    <fmt:message bundle="${loc}" key="local.services" var="services"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.home" var="home"/>
    <%@include file="partialHeader.jsp" %>
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script src="js/mapbasics.js" type="text/javascript"></script>
    <style>
        body, html {
            padding: 0;
            margin: 0;
            width: 100%;
            height: 100%;
        }
        #map {
            width: 100%;
            height: 90%;
        }
    </style>
</head>
<body class="" id="top">
<div class="main">
    <!--==============================header=================================-->
    <header>
        <div class="menu_block">
            <div class="container_12">
                <div class="grid_12">
                    <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                        <ul class="sf-menu">
                            <li><a href="/index">${home}</a></li>
                            <li><a href="/about">${about}</a></li>
                            <li><a href="/services">${services}</a></li>
                            <li class="current"><a href="/contacts">${contacts}</a></li>
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
                    <a href="index.html">
                        <img src="images/logo.png" alt="Your Happy Family">
                    </a>
                </h1>
            </div>
        </div>
        <div class="clear"></div>
    </header>


    <!--==============================Content=================================-->

    <div class="content">
        <div class="ic">More Website Templates @ TemplateMonster.com - April 07, 2014!</div>
        <div class="container_12">
            <div class="grid_12">
                <h3>Find Us</h3>
                <div id="map"></div>

            </div>
            <div class="grid_5">
                <h3>Contact Info</h3>
                <div class="map">
                    <div class="text1 color2">Lorem ipsum dolor sit amet, consecteturpiscinger elit um dolor sit amet,
                        consecteturpiscing.
                    </div>
                    <p>Don’t forget, 24/7 support is available for TemplateMonster’s <span class="color1"><a
                            href="http://www.templatemonster.com/website-templates.php"
                            rel="nofollow">premium themes</a></span> only. Free ones lack this privilege.</p>
                    <p>Use <span class="color1"><a href="http://www.templatetuning.com/"
                                                   rel="nofollow">Template Tuning</a></span> services if you need any
                        help in customization of your freebie.</p>
                    <address>
                        <dl>
                            <dt>The Company Name Inc. <br>
                                9870 St Vincent Place,<br>
                                Glasgow, DC 45 Fr 45.
                            </dt>
                            <dd><span>Telephone:</span> +1 800 603 6035</dd>
                            <dd><span>FAX:</span> +1 800 889 9898</dd>
                            <dd>E-mail: <a href="#" class="color1">mail@demolink.org</a></dd>
                        </dl>
                    </address>
                </div>
            </div>
            <div class="grid_6 prefix_1">
                <h3>Contact Form</h3>
                <form id="form">
                    <div class="success_wrapper">
                        <div class="success-message">Contact form submitted</div>
                    </div>
                    <label class="name">
                        <input type="text" placeholder="Name:" data-constraints="@Required @JustLetters"/>
                        <span class="empty-message">*This field is required.</span>
                        <span class="error-message">*This is not a valid name.</span>
                    </label>
                    <label class="email">
                        <input type="text" placeholder="E-mail:" data-constraints="@Required @Email"/>
                        <span class="empty-message">*This field is required.</span>
                        <span class="error-message">*This is not a valid email.</span>
                    </label>
                    <label class="phone">
                        <input type="text" placeholder="Phone:" data-constraints="@Required @JustNumbers"/>
                        <span class="empty-message">*This field is required.</span>
                        <span class="error-message">*This is not a valid phone.</span>
                    </label>
                    <label class="message">
                        <textarea placeholder="Message:"
                                  data-constraints='@Required @Length(min=20,max=999999)'></textarea>
                        <span class="empty-message">*This field is required.</span>
                        <span class="error-message">*The message is too short.</span>
                    </label>
                    <div>
                        <div class="clear"></div>
                        <div class="btns">
                            <a href="#" data-type="submit" class="btn">Send</a>
                            <a href="#" data-type="reset" class="btn">Clear</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

</body>
</html>
