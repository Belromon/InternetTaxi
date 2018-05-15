<%--
  Created by IntelliJ IDEA.
  User: RomanChepki
  Date: 08.04.2018
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

EDIT ACCOUNT
<br>
<form action="/FrontController" method="post" >
    <input type="hidden" name="command" value="EDIT_ACCOUNT">
    Enter name:<br />
    <input type="text" name="name" value="" required>
    <br/>
    Enter surname:<br />
    <input type="text" name="surname" value="" required>
    <br />

    <input type="submit" value="submit">
</form>


</body>
</html>
