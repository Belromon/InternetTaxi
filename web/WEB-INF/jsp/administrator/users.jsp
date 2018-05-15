<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script>
        function user_ban(id) {
            $.ajax({
                url: 'FrontController?command=BLOCK_USER&id='+id,
                success: function () {
                    $("#" + id).find(".isBannedTd").text("true");
                },
                error: function () {
                    alert('error');
                }
            });
        }

        function user_unban(id) {
            $.ajax({
                url: 'FrontController?command=UNBLOCK_USER&id='+id,
                success: function () {
                    $("#" + id).find(".isBannedTd").text("false");
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
        <c:when test="${not empty customers}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Last name</td>
                    <td>Login</td>
                    <td>Role</td>
                    <td>IsBanned</td>
                    <td>IsActive</td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <c:forEach var="users" items="${customers}">
                    <c:set var="classSucess" value=""/>
                    <c:if test="${idCustomer == users.id}">
                        <c:set var="classSucess" value="info"/>
                    </c:if>
                    <tr id="${users.id}" class="${classSucess}">
                        <td>${users.id}</td>
                        <td>${users.name}</td>
                        <td>${users.surname}</td>
                        <td>${users.login}</td>
                        <td>${users.role}</td>
                        <td class="isBannedTd">${users.banned}</td>
                        <td>${users.active}</td>

                        <td><a href="#" id="block"
                               onclick="user_ban(${users.id})">
                            <span class="glyphicon glyphicon-ban-circle"/>
                            </a>
                        </td>
                        <td>
                            <a href="#" id="unblock"
                               onclick="user_unban(${users.id})">
                                <span class="glyphicon glyphicon-leaf"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

    </c:choose>



</body>
</html>
