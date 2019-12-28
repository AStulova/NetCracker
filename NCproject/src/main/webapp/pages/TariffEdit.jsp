<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty tariff.idConnection}">
        <title>Add Connection</title>
    </c:if>
</head>
<body>
<c:if test="${empty tariff.idConnection}">
    <c:url value="/add-tariff" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${tariff.idConnection}">
    <label for="nameConnection">Name</label>
    <input type="text" name="nameConnection" id="nameConnection">
    <label for="priceMonth">Price per month</label>
    <input type="text" name="priceMonth" id="priceMonth">
    <label for="priceConnection">Connection cost</label>
    <input type="text" name="priceConnection" id="priceConnection">

    <c:if test="${empty tariff.idConnection}">
        <input type="submit" value="Add">
    </c:if>
</form>
</body>
</html>
