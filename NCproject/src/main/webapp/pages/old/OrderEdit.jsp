<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty order.idOrder}">
        <title>Add Order</title>
    </c:if>
    <c:if test="${!empty order.idOrder}">
        <title>Edit Order</title>
    </c:if>
</head>
<body>
<c:if test="${empty order.idOrder}">
    <c:url value="/add-order" var="var"/>
</c:if>
<c:if test="${!empty order.idOrder}">
    <c:url value="/edit-order" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${order.idOrder}">
    <label for="idClient">ID client</label>
    <input type="number" name="idClient" id="idClient">
    <label for="idConnection">ID tariff</label>
    <input type="number" name="idConnection" id="idConnection">
    <label for="priceOrder">Price</label>
    <input type="number" name="priceOrder" id="priceOrder">
    <label for="dateOrder">Order date</label>
    <input type="text" name="dateOrder" id="dateOrder">

    <c:if test="${empty order.idOrder}">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${!empty order.idOrder}">
        <input type="submit" value="Edit">
    </c:if>
</form>
</body>
</html>
