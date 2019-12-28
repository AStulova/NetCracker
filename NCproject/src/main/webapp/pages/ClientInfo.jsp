<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Information</title>
</head>
<body>
    <h1>Clients</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Balance</th>
            <th> </th>
        </tr>
        <c:forEach var="client" items="${clientList}">
            <tr>
                <td>${client.idClient}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.phone}</td>
                <td>${client.email}</td>
                <td>${client.balance}</td>
                <td>
                    <a href="/edit-client/${client.idClient}">Edit</a>
                    <a href="/delete-client/${client.idClient}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:url value="/add-client" var="add" />
    <a href="${add}">Add Client</a>
    <c:url value="/tariff" var="tariff"/>
    <a href="${tariff}">Services</a>
    <c:url value="/order" var="order"/>
    <a href="${order}">Orders</a>
    <c:url value="/bill" var="bill"/>
    <a href="${bill}">Accounts</a>
</body>
</html>