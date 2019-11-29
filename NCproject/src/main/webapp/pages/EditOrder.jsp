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
    <label for="id_client">ID client</label>
    <input type="number" name="id_client" id="id_client">
    <label for="id_connection">ID connection</label>
    <input type="number" name="id_connection" id="id_connection">
    <label for="price_order">Price</label>
    <input type="number" name="price_order" id="price_order">
    <label for="date_order">Order date</label>
    <input type="text" name="date_order" id="date_order">

    <c:if test="${empty order.idOrder}">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${!empty order.idOrder}">
        <input type="submit" value="Edit">
    </c:if>
</form>
</body>
</html>
