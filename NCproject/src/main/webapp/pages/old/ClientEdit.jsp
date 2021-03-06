<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty client.idClient}">
        <title>Add Client</title>
    </c:if>
    <c:if test="${!empty client.idClient}">
        <title>Edit Client</title>
    </c:if>
</head>
<body>
    <c:if test="${empty client.idClient}">
        <c:url value="/add-client" var="var"/>
    </c:if>
    <c:if test="${!empty client.idClient}">
        <c:url value="/edit-client" var="var"/>
    </c:if>

    <form action="${var}" method="POST">
        <input type="hidden" name="id" value="${client.idClient}">
        <label for="fullName">Full name</label>
        <input type="text" name="fullName" id="fullName">
        <label for="phone">Phone</label>
        <input type="text" name="phone" id="phone">
        <label for="email">Email</label>
        <input type="text" name="email" id="email">
        <label for="personalAccount">Personal bill</label>
        <input type="text" name="personalAccount" id="personalAccount">
        <label for="balance">Balance</label>
        <input type="text" name="balance" id="balance">

        <c:if test="${empty client.idClient}">
            <input type="submit" value="Add">
        </c:if>
        <c:if test="${!empty client.idClient}">
            <input type="submit" value="Edit">
        </c:if>
    </form>
</body>
</html>
