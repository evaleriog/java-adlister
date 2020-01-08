<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Guessing Game</title>
    </head>
    <% int solutionNumber = (int)(Math.random() * 100) + 1; %>
    <body>
        <h1>Welcome to the Guessing Game</h1>

        <form method="POST" action="guess.jsp">
<%--            <c:set var="number" value="${param.number}" />--%>
            <label>Enter a number between 1 - 100: </label>
            <input id="number" name="number">
            <input type="submit" name="submit" value="Submit">
        </form>

        <%
            try{
                int userGuess = Integer.parseInt(request.getParameter("number"));
                boolean again;
                String message;

                if(userGuess > 0 && userGuess < 101){
                    if(solutionNumber > userGuess){
                        again = true;
                        message = "Lower";
//                        request.setAttribute("message", "Lower");
//                        request.setAttribute("again", true);
                    }else if(solutionNumber < userGuess){
                        again = true;
                        message = "Higuer";
//                        request.setAttribute("message", "Higuer");
//                        request.setAttribute("again", true);
                    }else {
                        again = false;
                        message = "Won";
//                        request.setAttribute("message", "Won");
                    }
                    response.sendRedirect("/guessresult.jsp?again=" + again + "&message=" + message + "&number=" + solutionNumber);
                }else {
                    request.setAttribute("message", "Please enter a number between 1 and 100");
                }

            }catch (Exception e){
                request.setAttribute("message", "Not a valid number");
            }

        %>
        <p>${message}</p>
    </body>
</html>