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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <style id="jsbin-css">
        td {
            border: 1px #DDD solid;
            padding: 5px;
            cursor: pointer;
        }

        .selected {
            background-color: brown !important;
            color: #FFF;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.1.0.js"></script>
    <%@include file="partialHeader.jsp" %>

    <link rel="stylesheet" href="css/booking.css">

</head>
<body class="page1" id="top">
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
                            <li class="current"><a href="/FrontController?command=LOGOUT">Log Out</a></li>
                        </ul>
                    </nav>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

    </header>

    <div class="content">
        <div class="container_12">
            <h3>Booking Form</h3>
            <form id="bookingForm" action="FrontController" method="post">
                <input type="hidden" name="command" value="CREATE_ORDER">
                <input style="width: 400px;height: 47px;" name="from" placeholder="From:" type="text" required="true">

                <input style="width: 400px;margin-left: 50px;height: 47px;" name="destination" placeholder="To:"
                       type="text" required="true">
                <input class="btn" id="bookSuccessButtonId" type="submit" value="Submit"
                       style="margin-left: 45px;margin-bottom: 16px;height: 45px;width: 128px; background-color:#fdc903">
                <div class="clear"></div>
            </form>
            <div class="clear"></div>
        </div>

        <br>
        <form action="FrontController" method="post" id="userForm">
            <input type="hidden" name="command" value="FIND_DRIVER"/>
            <input type="hidden" id="idDriver" name="idDriver"/>
            <c:choose>
                <c:when test="${not empty driverList}">
                    <table class="table table-striped" id="table">
                        <thead>
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Last name</td>
                            <td>CarNumber</td>
                            <td>CarModel</td>
                            <td>Location</td>
                        </tr>
                        </thead>
                        <c:forEach var="drivers" items="${driverList}">
                            <c:set var="classSucess" value=""/>
                            <c:if test="${idDriver == drivers.id}">
                                <c:set var="classSucess" value="info"/>
                            </c:if>
                            <tr class="${classSucess}">


                                <td>${drivers.id}</td>
                                <td>${drivers.name}</td>
                                <td>${drivers.surname}</td>
                                <td>${drivers.carNumber}</td>
                                <td>${drivers.carModel}</td>
                                <td>${drivers.location}</td>


                            </tr>
                        </c:forEach>
                    </table>
                    <input type="submit" value="Book" class="ok">
                </c:when>
                <c:otherwise>


                </c:otherwise>
            </c:choose>


        </form>

        <script id="jsbin-javascript">
            var id
            $("#table tr").click(function () {
                $(this).addClass('selected').siblings().removeClass('selected');
                id = $(this).find('td:first').html();
            });

            $('.ok').on('click', function (e) {
                document.getElementById('idDriver').value = id;
                document.getElementById("userForm").submit();
                alert("Please wait for accepting order by driver");

            });
        </script>

        <%--------------------SANDBOX-------------------------%>
        <%--<script type="text/javascript"--%>
        <%--src="https://api-maps.yandex.ru/2.0/?load=package.standard,package.route&lang=ru-RU"></script>--%>
        <%--<div id="map" style="width:800px; height:500px"></div>--%>

        <%--<script>--%>

        <%--function showTopDrivers() {--%>
        <%--$.ajax({--%>
        <%--url: 'FrontController?command=CREATE_ORDER',--%>
        <%--data: {--%>
        <%--begin_coord_x: this._start[0],--%>
        <%--begin_coord_y: this._start[1],--%>
        <%--end_coord_x: this._finish[0],--%>
        <%--end_coord_y: this._finish[1],--%>
        <%--from: this._fromAddr,--%>
        <%--destination: this._destinatoinAddr,--%>
        <%--},--%>
        <%--success: function () {--%>
        <%--$("#" + id).find(".isBannedTd").text("true");--%>
        <%--},--%>
        <%--error: function () {--%>
        <%--alert('error');--%>
        <%--}--%>
        <%--});--%>

        <%--}--%>

        <%--function init() {--%>
        <%--var myMap = new ymaps.Map('map', {--%>
        <%--center: [53.9000000, 27.5666700],--%>
        <%--zoom: 12,--%>
        <%--type: 'yandex#map',--%>
        <%--behaviors: ['scrollZoom', 'drag']--%>
        <%--}),--%>
        <%--searchStartPoint = new ymaps.control.SearchControl({--%>
        <%--useMapBounds: true,--%>
        <%--noPlacemark: true,--%>
        <%--noPopup: true,--%>
        <%--placeholderContent: 'Адрес начальной точки'--%>
        <%--}),--%>
        <%--searchFinishPoint = new ymaps.control.SearchControl({--%>
        <%--useMapBounds: true,--%>
        <%--noCentering: true,--%>
        <%--noPopup: true,--%>
        <%--noPlacemark: true,--%>
        <%--placeholderContent: 'Адрес конечной точки'--%>
        <%--}),--%>
        <%--calculator = new DeliveryCalculator(myMap, myMap.getCenter());--%>

        <%--myMap.controls.add(searchStartPoint, {left: 5, top: 5});--%>
        <%--myMap.controls.add(searchFinishPoint, {left: 5, top: 40});--%>

        <%--searchStartPoint.events.add('resultselect', function (e) {--%>
        <%--var results = searchStartPoint.getResultsArray(),--%>
        <%--selected = e.get('resultIndex'),--%>
        <%--point = results[selected].geometry.getCoordinates();--%>

        <%--calculator.setStartPoint(point);--%>
        <%--});--%>

        <%--searchFinishPoint.events.add('resultselect', function (e) {--%>
        <%--var results = searchFinishPoint.getResultsArray(),--%>
        <%--selected = e.get('resultIndex'),--%>
        <%--point = results[selected].geometry.getCoordinates();--%>

        <%--calculator.setFinishPoint(point);--%>
        <%--});--%>


        <%--}--%>

        <%--function DeliveryCalculator(map, finish) {--%>
        <%--this._map = map;--%>
        <%--this._start = null;--%>
        <%--this._route = null;--%>

        <%--map.events.add('click', this._onClick, this);--%>
        <%--}--%>

        <%--var ptp = DeliveryCalculator.prototype;--%>

        <%--ptp._onClick = function (e) {--%>
        <%--if (this._start) {--%>
        <%--this.setFinishPoint(e.get('coordPosition'));--%>
        <%--} else {--%>
        <%--this.setStartPoint(e.get('coordPosition'));--%>
        <%--}--%>
        <%--};--%>

        <%--ptp._onDragEnd = function (e) {--%>
        <%--this.getDirection();--%>
        <%--}--%>

        <%--ptp.getDirection = function () {--%>
        <%--showTopDrivers();--%>
        <%--if (this._route) {--%>
        <%--this._map.geoObjects.remove(this._route);--%>
        <%--}--%>

        <%--if (this._start && this._finish) {--%>
        <%--var self = this,--%>
        <%--start = this._start.geometry.getCoordinates(),--%>
        <%--finish = this._finish.geometry.getCoordinates();--%>

        <%--ymaps.geocode(start, {results: 1})--%>
        <%--.then(function (geocode) {--%>
        <%--var address = geocode.geoObjects.get(0) &&--%>
        <%--geocode.geoObjects.get(0).properties.get('balloonContentBody') || '';--%>
        <%--alert(address);--%>

        <%--ymaps.route([start, finish])--%>
        <%--.then(function (router) {--%>
        <%--var distance = Math.round(router.getLength() / 1000),--%>
        <%--message = '<span>Расстояние: ' + distance + 'км.</span><br/>' +--%>
        <%--'<span style="font-weight: bold; font-style: italic">Стоимость доставки: %sр.</span>';--%>

        <%--self._route = router.getPaths();--%>

        <%--self._route.options.set({strokeWidth: 5, strokeColor: '0000ffff', opacity: 0.5});--%>
        <%--self._map.geoObjects.add(self._route);--%>
        <%--self._start.properties.set('balloonContentBody', address + message.replace('%s', self.calculate(distance)));--%>

        <%--});--%>
        <%--});--%>


        <%--self._map.setBounds(self._map.geoObjects.getBounds())--%>
        <%--}--%>
        <%--};--%>

        <%--ptp.setStartPoint = function (position) {--%>
        <%--if (this._start) {--%>
        <%--this._start.geometry.setCoordinates(position);--%>
        <%--}--%>
        <%--else {--%>
        <%--this._start = new ymaps.Placemark(position, {iconContent: 'А'}, {draggable: true});--%>
        <%--this._start.events.add('dragend', this._onDragEnd, this);--%>
        <%--this._map.geoObjects.add(this._start);--%>
        <%--}--%>
        <%--this.getDirection();--%>
        <%--};--%>

        <%--ptp.setFinishPoint = function (position) {--%>
        <%--if (this._finish) {--%>
        <%--this._finish.geometry.setCoordinates(position);--%>
        <%--}--%>
        <%--else {--%>
        <%--this._finish = new ymaps.Placemark(position, {iconContent: 'Б'}, {draggable: true});--%>
        <%--this._finish.events.add('dragend', this._onDragEnd, this);--%>
        <%--this._map.geoObjects.add(this._finish);--%>
        <%--}--%>
        <%--this.getDirection();--%>
        <%--};--%>

        <%--ptp.calculate = function (len) {--%>
        <%--// Константы.--%>
        <%--var DELIVERY_TARIF = 20,--%>
        <%--MINIMUM_COST = 10;--%>
        <%--alert(Math.max(len * DELIVERY_TARIF, MINIMUM_COST));--%>
        <%--return Math.max(len * DELIVERY_TARIF, MINIMUM_COST);--%>
        <%--};--%>

        <%--ymaps.ready(init);--%>


        <%--</script>--%>
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


