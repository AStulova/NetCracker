<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty bill.idBill}">
        <title>Add Bill</title>
    </c:if>
    <c:if test="${!empty bill.idBill}">
        <title>Edit Bill</title>
    </c:if>
</head>
<body>
<c:if test="${empty bill.idBill}">
    <c:url value="/add-bill" var="var"/>
</c:if>
<c:if test="${!empty bill.idBill}">
    <c:url value="/edit-bill" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${bill.idBill}">
    <label for="idClient">ID client</label>
    <input type="text" name="idClient" id="idClient">
    <label for="total">Total</label>
    <input type="text" name="total" id="total">


    <c:if test="${empty bill.idBill}">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${!empty bill.idBill}">
        <input type="submit" value="Edit">
    </c:if>
</form>
</body>
</html>
