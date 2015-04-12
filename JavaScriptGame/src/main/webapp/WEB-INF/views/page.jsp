<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>A simple JavaScript Game</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <h1>Do you want to play a game?</h1>

        <p><strong>Questions:</strong></p>

        <form action="/game" method="POST">
            <c:forEach var="question" items="${questions}">
                <p>${question}</p>
                <input name="answer" type="text"/>
            </c:forEach>
                <br></br>
            <input type="submit" value="Submit answers"/>
        </form>
        <ul>
            <c:forEach var="result" items="${results}">
                <li>${result}</li>
                </c:forEach>
        </ul>

    </body>
</html>
