
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>

    <script>
        function driver_ban(id) {
            $.ajax({
                url: 'FrontController?command=BLOCK_DRIVER&id='+id,
                success: function () {
                    $("#" + id).find(".isBannedTd").text("true");
                },
                error: function () {
                    alert('error');
                }
            });
        }

        function driver_unban(id) {
            $.ajax({
                url: 'FrontController?command=UNBLOCK_DRIVER&id='+id,
                success: function () {
                    $("#" + id).find(".isBannedTd").text("false");
                },
                error: function () {
                    alert('error');
                }
            });
        }

        function driver_confirm(id) {
            $.ajax({
                url: 'FrontController?command=CONFIRM_DRIVER&id='+id,
                success: function () {
                    $("#" + id).find(".isConfirmedTd").text("true");
                },
                error: function () {
                    alert('error');
                }
            });
        }
    </script>

</head>
<body>

<c:if test="${not empty message}">
    <div class="alert alert-success">
            ${message}
    </div>
</c:if>
 <c:choose>
        <c:when test="${not empty drivers}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Last name</td>
                    <td>Login</td>
                    <td>IsBanned</td>
                    <td>IsFree</td>
                    <td>CarNumber</td>
                    <td>CarModel</td>
                    <td>Location</td>
                    <td>IsActive</td>
                    <td>IsConfirmed</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <c:forEach var="drivers" items="${drivers}">
                    <c:set var="classSucess" value=""/>
                    <c:if test="${idDriver == drivers.id}">
                        <c:set var="classSucess" value="info"/>
                    </c:if>
                    <tr id="${drivers.id}" class="${classSucess}">


                        <td>${drivers.id}</td>
                        <td>${drivers.name}</td>
                        <td>${drivers.surname}</td>
                        <td>${drivers.login}</td>
                        <td class="isBannedTd">${drivers.banned}</td>
                        <td>${drivers.free}</td>
                        <td>${drivers.carNumber}</td>
                        <td>${drivers.carModel}</td>
                        <td>${drivers.location}</td>
                        <td>${drivers.active}</td>
                        <td class="isConfirmedTd"> ${drivers.confirmed}</td>

                        <td><a href="#" id="ban"

                               onclick="driver_ban(${drivers.id})">
                            <span class="glyphicon glyphicon-ban-circle"/>
                            </a>
                        </td>
                        <td>
                            <a href="#" id="unban"

                               onclick="driver_unban(${drivers.id})">
                                <span class="glyphicon glyphicon-leaf"/>
                            </a>
                        </td>
                        <td><a href="#" id="confirm"

                               onclick="driver_confirm(${drivers.id})">
                            <span class="glyphicon glyphicon-ok"/>
                        </a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </c:when>

    </c:choose>

</body>
</html>
