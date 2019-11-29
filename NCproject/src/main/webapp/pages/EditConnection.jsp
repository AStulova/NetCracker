<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty connection.idConnection}">
        <title>Add Connection</title>
    </c:if>
</head>
<body>
<c:if test="${empty connection.idConnection}">
    <c:url value="/add" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${connection.idConnection}">
    <label for="name_connection">Name</label>
    <input type="text" name="name_connection" id="name_connection">
    <label for="price_month">Price per month</label>
    <input type="text" name="price_month" id="price_month">
    <label for="price_connection">Connection cost</label>
    <input type="text" name="price_connection" id="price_connection">

    <c:if test="${empty connection.idConnection}">
        <input type="submit" value="Add">
    </c:if>
</form>
</body>
</html>
