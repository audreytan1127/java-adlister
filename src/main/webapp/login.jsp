<%--
  Created by IntelliJ IDEA.
  User: audreytan
  Date: 8/28/23
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="go" uri="http://java.sun.com/jsp/jstl/core"%>
<%--Includes the navbar--%>
<%@ include file="partials/navbar.jsp"%>
<html>
<head>
    <title>Login</title>
<%--    Includes the link to stylesheet.css--%>
    <%@ include file="partials/head.jsp"%>
</head>
<body>
<%-- Start of JSP if/else statement --%>
<go:choose>
<%--    The if conditional checking if the username is admin and password is password--%>
    <go:when test="${param.username eq 'admin' && param.password eq 'password'}">
<%--        If conditions are met, the page will be redirected to profile page --%>
            <go:redirect url="profile.jsp">
            </go:redirect>
    </go:when>
<%--End of if statement--%>

<%--    The else statement if admin and password are not the input --%>
    <go:otherwise>
        <p> Please submit your login!</p>
<%--        Will print the form in HTML: method of form set to POST and action will open to login.jsp when form is submitted (asks user to log in again)--%>
        <form method="POST" action="login.jsp">
            <input type="text" name="username" placeholder="Enter username"><br>
            <input type="password" name="password" placeholder="Enter password"><br>
            <button type="submit">Submit</button><br>
        </form>
    </go:otherwise>
</go:choose>

</body>
</html>
