<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <%
            String selectedColor = request.getParameter("color");
            request.setAttribute("color", selectedColor);
        %>
        <title>${color}</title>
    </head>

    <body style="background-color: ${color}">
        <h1>You selected ${color} as your favorite color</h1>
    </body>
</html>