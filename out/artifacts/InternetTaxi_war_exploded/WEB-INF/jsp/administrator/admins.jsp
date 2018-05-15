
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script>
        function delete_admin(id){


            if(confirm("Are you sure?"))
            {
                $.ajax({
                    url: 'FrontController?command=DELETE_ADMIN&id='+id,
                    success: function () {
                        $("#" + id).find(".isActiveTd").text("false");
                    },
                    error: function () {
                        alert('error');
                    }
                });
            }
            else
            {
                event.preventDefault();
            }



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
    <c:when test="${not empty admins}">
        <table class="table table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Last name</td>
                <td>Login</td>
                <td>Role</td>
                <td>IsActive</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <c:forEach var="admin" items="${admins}">
                <c:set var="classSucess" value=""/>
                <tr id="${admin.id}" class="${classSucess}">
                    <td>${admin.id}</td>
                    <td>${admin.name}</td>
                    <td>${admin.surname}</td>
                    <td>${admin.login}</td>
                    <td>${admin.role}</td>
                    <td class="isActiveTd">${admin.active}</td>
                    <td><a href="#" id="block"
                           onclick="delete_admin(${admin.id})">
                        <span class="glyphicon glyphicon glyphicon-remove"/>
                    </a>

                </tr>
            </c:forEach>
        </table>
    </c:when>

</c:choose>

</body>
</html>
