<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bills</title>
</head>
<body>
<h1>Bills Information</h1>
<table>
    <tr>
        <th>ID bill</th>
        <th>ID client</th>
        <th>Date</th>
        <th> </th>
    </tr>
    <c:forEach var="bill" items="${billList}">
        <tr>
            <td>${bill.idBill}</td>
            <td>${bill.idClient}</td>
            <td>${bill.dateBill}</td>
            <td>
                <a href="/edit-bill/${bill.idBill}">Edit</a>
                <a href="/delete-bill/${bill.idBill}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/add-bill" var="add" />
<a href="${add}">Add Account</a>
</body>
</html>