<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Services</title>
</head>
<body>
<h1>Services</h1>
<table>
    <tr>
        <th>ID Service</th>
        <th>Name</th>
        <th>Price per month</th>
        <th>Connection cost</th>
        <th> </th>
    </tr>
    <c:forEach var="connection" items="${connectionList}">
        <tr>
            <td>${connection.idConnection}</td>
            <td>${connection.nameConnection}</td>
            <td>${connection.priceMonth}</td>
            <td>${connection.priceConnection}</td>
            <td>
                <a href="/delete-connection/${connection.idConnection}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/add-connection" var="add" />
<a href="${add}">Add Connection</a>
</body>
</html>