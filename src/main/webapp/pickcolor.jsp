<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Welcome</title>
    </head>

    <body>
        <h1>Pick Color</h1>
        <form method="POST" action="selectedcolor.jsp">
            <label>Select your favorite color: </label>
            <input id="color" name="color">
            <input type="submit" name="submit" value="Submit">
        </form>
    </body>
</html>