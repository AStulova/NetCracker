<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h1>Orders</h1>
<table>
    <tr>
        <th>ID order</th>
        <th>ID client</th>
        <th>ID tariff</th>
        <th>Price</th>
        <th>Order date</th>
        <th> </th>
    </tr>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.idOrder}</td>
            <td>${order.idClient}</td>
            <td>${order.idConnection}</td>
            <td>${order.priceOrder}</td>
            <td>${order.dateOrder}</td>

            <td>
                <a href="/edit-order/${order.idOrder}">Edit</a>
                <a href="/delete-order/${order.idOrder}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/add-order" var="add" />
<a href="${add}">Add Order</a>

</body>
</html>