<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update Contacts</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>
    <h1>Update Contact</h1>
    <form method="POST" action="/update">
        <div class="form-group">
            <label>ID</label>
            <input id="id" name="id">
        </div>

        <div class="form-group">
            <label>First Name</label>
            <input id="first" name="first">
        </div>

        <div class="form-group">
            <label>Last Name</label>
            <input id="last" name="last">
        </div>

        <div class="form-group">
            <label>Phone</label>
            <input id="phone" name="phone">
        </div>
        <input type="submit" id="submit" name="submit" value="Submit">

    </form>
</body>
</html>