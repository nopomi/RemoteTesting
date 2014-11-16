<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Your results</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <h1>Your Results</h1>

        <div>
            <ul>


                <c:forEach var="result" items="${results}">

                    <li>${result}</li>

                </c:forEach>

            </ul>
        </div>

    </body>
</html>
