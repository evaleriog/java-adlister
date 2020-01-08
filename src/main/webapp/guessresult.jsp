<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title></title>
    </head>

    <body>
        <p><%=request.getParameter("message")%></p>
        <p><%=request.getParameter("again")%></p>
        <%
            String message = request.getParameter("message");
            String again = request.getParameter("again");
            request.setAttribute("message", message);
            request.setAttribute("number", request.getParameter("number"));

            if(again.equals("true")){
                request.setAttribute("again", true);
            }else {
                request.setAttribute("again", false);
            }
        %>
        <h1>Let's see what you got....</h1>
        <p>${again}</p>
        <c:choose>
            <c:when test="${again}">
                <p>Sorry, wrong number....you need to go ${message}</p>
                <a href="guess.jsp">Try again...</a>
            </c:when>
            <c:otherwise>
                <p>Congratulations, you ${message}</p>
            </c:otherwise>
        </c:choose>
        <p>${number}</p>
    </body>
</html>