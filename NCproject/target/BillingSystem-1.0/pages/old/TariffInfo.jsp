<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tariffs</title>
</head>
<body>
<h1>Tariffs</h1>
<table>
    <tr>
        <th>ID Tariff</th>
        <th>Tariff name</th>
        <th>Type</th>
        <th>Price for 1 SMS/Gb/min</th>
        <th> </th>
    </tr>
    <c:forEach var="tariff" items="${tariffList}">
        <tr>
            <td>${tariff.idTariff}</td>
            <td>${tariff.nameTariff}</td>
            <td>${tariff.typeTariff}</td>
            <td>${tariff.priceTariff}</td>
            <td>
                <a href="/delete-tariff/${tariff.idTariff}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/add-tariff" var="add" />
<a href="${add}">Add Tariff</a>
</body>
</html>