<%--
  Created by IntelliJ IDEA.
  User: audreytan
  Date: 8/28/23
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="go" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="partials/navbar.jsp"%>
<%@ include file="partials/head.jsp"%>
<html>
<body>

<go:choose>
    <go:when test="${param.username eq 'admin' && param.password eq 'password'}">
            <go:redirect url="profile.jsp">
            </go:redirect>
    </go:when>

    <go:otherwise>
        <p> Please submit your login!</p>
        <form method="POST" action="login.jsp">
            <input type="text" name="username" placeholder="Enter username"><br>
            <input type="password" name="password" placeholder="Enter password"><br>
            <button type="submit">Submit</button><br>
        </form>
    </go:otherwise>
</go:choose>

</body>
</html>
