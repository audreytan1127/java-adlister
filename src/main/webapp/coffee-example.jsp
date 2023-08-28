<%--
  Created by IntelliJ IDEA.
  User: audreytan
  Date: 8/28/23
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%--Need this page directive on JSP--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Need this uri to link jstl library--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Declare instance variable --%>
<%! int customers = 0;
boolean methodIsGet = false;
%>
<%-- Adjusts instance variables --%>
<% customers ++;
    if (request.getMethod().equalsIgnoreCase("GET")) {

        methodIsGet = true;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--To add another JSP file--%>
<%@include file="partials/navbar.jsp"%>

<%--Analyze and print instance variable--%>
<h1> We have had <%= customers %> customers visit this site! </h1>

<%-- Will print the query string when localhost:8080/coffee-example.jsp?coffee=prints+whatever+is+here --%>
<p> The coffee parameter is currently ${param.coffee}</p>

<%-- Prints whatever the method of the webpage is!--%>
<p> The Method is GET? <%= methodIsGet %>.</p>

<form method="POST" action="coffee-example.jsp">
    <input type ="text" name="coffeename" placeholder="Enter a Coffee">
    <input type="text" name="username" placeholder="Enter your name">

    <label for="caramel-checkbox">Caramel</label>
    <input id="caramel-checkbox" type="checkbox" name="addons" value="Caramel">

    <label for="milk-checkbox">Milk</label>
    <input id="milk-checkbox" type="checkbox" name="addons" value="Milk">

    <label for="sugar-checkbox">Sugar</label>
    <input id="sugar-checkbox" type="checkbox" name="addons" value="Sugar">

    <button type="submit">Submit</button>

</form>

<%-- To declare if/else block--%>
<c:choose>

<%--    If conditional statement--%>
    <c:when test="${param.coffeename != null}">
        <c:if test="${param.coffeename != null}">
            <p> Coffee chosen: ${param.coffeename}</p>
        </c:if>

        <c:if test="${param.username != null}">
            <p> User is: ${param.username}</p>
        </c:if>

        <c:if test="${paramValues.addons != null}">
            <ul>
                <c:forEach var="addon" items="${paramValues.addons}">
                    <li>${addon}</li>
                </c:forEach>
            </ul>
        </c:if>

    </c:when>

<%--    The else statement --%>
    <c:otherwise>
        <p>Please fill out the form.</p>
    </c:otherwise>

</c:choose>



<%--To add javascript--%>
<script src = "js/add-new-js.js"></script>
</body>
</html>
