
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Register New User</title>
</head>
<body>
<div class="container">
    <h1>Register New User!</h1>
    <c:if test="${invalid ==true}">
        <h2>Invalid inputs, please try again.</h2>
    </c:if>
    <form action="/register" method="POST">
        <label for="email"><h2>Please enter your email.</h2></label>
        <input type="email" id="email" name="email" required placeholder="Enter your email">
        <label for="username"><h2>Please enter your username.</h2></label>
        <input type="text" id="username" name="username" required placeholder="Enter in a username">
        <label for="password"><h2>Please enter a password.</h2></label>
       <input type="password" id="password" name="password" required placeholder="Enter in a password">
        <label for="confirm-password"><h2>Please confirm your password.</h2></label>
        <input type="password" id="confirm-password" name="confirm-password" required placeholder="Confirm password">
        <br>
        <hr>
        <button type="submit">Register!</button>
    </form>
</div>
</body>
</html>
