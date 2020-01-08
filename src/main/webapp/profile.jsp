<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<% String name = request.getParameter("username"); %>

<jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="<%=name%>"/>
</jsp:include>
<body>
<jsp:include page="partials/navbar.jsp" />
<h1>Welcome <%=name%></h1>

</body>