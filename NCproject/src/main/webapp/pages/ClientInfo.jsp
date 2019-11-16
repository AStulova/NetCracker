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
            <th>Full Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Personal Account</th>
            <th>Balance</th>
            <th> </th>
        </tr>
        <c:forEach var="client" items="${clientList}">
            <tr>
                <td>${client.idClient}</td>
                <td>${client.fullName}</td>
                <td>${client.phone}</td>
                <td>${client.email}</td>
                <td>${client.personalAccount}</td>
                <td>${client.balance}</td>
                <td>
                    <a href="/edit/${client.idClient}">Edit</a>
                    <a href="/delete/${client.idClient}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:url value="/add" var="add" />
    <a href="${add}">Add Client</a>
</body>
</html>