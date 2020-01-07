<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Website</title>
</head>
<body>
    <h1>Please Log In</h1>

<%--    <%boolean isAdmin = false;%>--%>
    <c:set var="isAdmin" value="false"/>

    <form method="POST" action="login.jsp">
        <c:set var="username" value="${param.username}" />
        <label for="username">Username</label>
        <input id="username" name="username">
        <c:set var="password" value="${param.password}" />
        <label for="password">Password</label>
        <input id="password" name="password">
        <input type="submit" name="Submit" value="Submit">
    </form>

    <c:choose>
        <c:when test="${username != null}">
<%--            <%isAdmin = true;%>--%>
            <c:set var="isAdmin" value="true"/>
        </c:when>
        <c:otherwise>
            <c:set var="isAdmin" value="false"/>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${username.equals('admin')}">
            <c:set var="isAdmin" value="true"/>
        </c:when>
        <c:otherwise>
            <c:set var="isAdmin" value="false"/>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${password.equals('password')}">
            <c:set var="isAdmin" value="true"/>
        </c:when>
        <c:otherwise>
            <c:set var="isAdmin" value="false"/>
        </c:otherwise>
    </c:choose>

    <c:if test="${isAdmin == true}">
        <%response.sendRedirect("/profile.jsp");%>
    </c:if>
</body>