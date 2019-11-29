<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
<h1>Accounts Information</h1>
<table>
    <tr>
        <th>ID account</th>
        <th>ID client</th>
        <th>Total</th>
        <th> </th>
    </tr>
    <c:forEach var="account" items="${accountList}">
        <tr>
            <td>${account.idAccount}</td>
            <td>${account.idClient}</td>
            <td>${account.totalAccount}</td>
            <td>
                <a href="/edit-account/${account.idAccount}">Edit</a>
                <a href="/delete-account/${account.idAccount}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/add-account" var="add" />
<a href="${add}">Add Account</a>
</body>
</html>