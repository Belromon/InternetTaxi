<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Services</title>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.about" var="about"/>
    <fmt:message bundle="${loc}" key="local.services" var="services"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.home" var="home"/>
    <%@include file="partialHeader.jsp"%>
</head>
<body class="" id="top">
<div class="main">
    <!--==============================header=================================-->
    <header>
        <div class="menu_block ">
            <div class="container_12">
                <div class="grid_12">
                    <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                        <ul class="sf-menu">
                            <li><a href="/index">${home}</a></li>
                            <li><a href="/about">${about}</a></li>
                            <li class="current"><a href="/services">${services}</a></li>
                            <li><a href="/contacts">${contacts}</a></li>
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
    <div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 07, 2014!</div>
        <div class="container_12">
            <div class="grid_12">
                <h3>Services Overview</h3>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img1.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Lorem ipsum dolor sit amet, consecteturpiscinger elit.</a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img2.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Dorem ipsum dolor sit amet, consecteturpiscinger elite. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img3.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Horempsum dolor sit amet, consecteturpiscinger eliterty. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img4.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Gorem ipsum dolor sit ametertol, consecteturpiscinger elit. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img5.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Norem ipsum dolor sit ametew, consecteturpiscinger eliterty. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img6.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Ipsum dolor sit ametertoli loputyu, consecteturpiscinger elitwer. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img7.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Korem ipsum dolor sit ameter, consecteturpiscinger eliterlo. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img8.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Horem ipsum dolor sit amet, consecteturpiscinger eliter. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="grid_4">
                <div class="box">
                    <div class="maxheight">
                        <img src="images/page4_img9.jpg" alt="">
                        <div class="text1 color2">
                            <a href="#">Morem ipsum dolor sit ametolo, consecteturpiscinger eliter. </a>
                        </div>
                        Sit meter ultricies erat rutrum. Cras er te facilisis, nulla vel viver auctor, leo magna sodales felis, quis malesuad nibh odio ut velit.
                        <br>
                        <a href="#" class="btn">Read More</a>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<!--==============================footer=================================-->
<footer>
    <div class="container_12">
        <div class="grid_12">
            <div class="f_phone"><span>Call Us:</span> + 1800 559 6580</div>
            <div class="socials">
                <a href="#" class="fa fa-twitter"></a>
                <a href="#" class="fa fa-facebook"></a>
                <a href="#" class="fa fa-google-plus"></a>
            </div>
            <div class="copy">
                <div class="st1">
                    <div class="brand">Tour<span class="color1">T</span>axi </div>
                    &copy; 2014	| <a href="#">Privacy Policy</a> </div> Website designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</footer>
</body>
</html>
