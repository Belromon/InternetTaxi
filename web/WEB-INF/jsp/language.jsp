<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:choose>
    <c:when test="${sessionScope.locale == 'ru'}">
        <a href="/FrontController?command=LOCALIZATION&from=${pageContext.request.requestURI}&locale=en">English</a>
    </c:when>
    <c:when test="${sessionScope.locale == 'en'}">
        <a href="/FrontController?command=LOCALIZATION&from=${pageContext.request.requestURI}&locale=ru">Русский</a>
    </c:when>
    <c:otherwise>
        <a href="/FrontController?command=LOCALIZATION&from=${pageContext.request.requestURI}&locale=en">English</a>
    </c:otherwise>
</c:choose>


