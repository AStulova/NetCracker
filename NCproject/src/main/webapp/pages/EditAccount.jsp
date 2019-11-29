<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty account.idAccount}">
        <title>Add Account</title>
    </c:if>
    <c:if test="${!empty account.idAccount}">
        <title>Edit Account</title>
    </c:if>
</head>
<body>
<c:if test="${empty account.idAccount}">
    <c:url value="/add-account" var="var"/>
</c:if>
<c:if test="${!empty account.idAccount}">
    <c:url value="/edit-account" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${account.idAccount}">
    <label for="id_client">ID client</label>
    <input type="text" name="id_client" id="id_client">
    <label for="total">Total</label>
    <input type="text" name="total" id="total">


    <c:if test="${empty account.idAccount}">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${!empty account.idAccount}">
        <input type="submit" value="Edit">
    </c:if>
</form>
</body>
</html>
