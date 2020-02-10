<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Profile</title>
    <!-- Bootstrap -->
    <style>
        <%@include file='css/bootstrap.min.css' %>
        <%@include file='css/stylesheet.css' %>
    </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary" style> <!-- fixed-top -->
    <div class="container">
        <a class="navbar-brand" href="/client">BillSYS</a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive" style>
            <ul class="navbar-nav mr-auto">
                <c:if test="${role eq 'EMPLOYEE'}">
                    <li class="nav-item">
                        <a class="nav-link" href="/clients">Clients</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="/tariff">Tariffs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/order">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/bill">Bills</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">Personal Information<span class="caret"></span></a>
                    <div class="dropdown-menu" aria-labelledby="download">
                        <a class="dropdown-item" href="/client">Info</a>
                        <form:form action="/logout" method="post">
                            <input class="dropdown-item" type="submit" value="Sign out">
                        </form:form>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page -->
<div class="bs-docs-section clearfix">
    <div class="container">
        <div class="page-header" id="banner">
            <div class="row">
                <div class="col-lg-8 col-md-7 col-sm-6">
                    <h1>Clients</h1>
                    <p class="lead"> </p>
                </div>
            </div>
        </div>

        <!-- Clients Table -->
        <table class="table table-borderless">
            <thead>
            <tr>
                <th scope="col">ID Client</th>
                <th scope="col">First name</th>
                <th scope="col">Last name</th>
                <th scope="col">Phone</th>
                <th scope="col">Email</th>
                <th scope="col">Balance</th>
                <th class="text-right"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="client" items="${clientList}">
                    <tr class="bg-light">
                        <td class="align-middle">${client.idClient}</td>
                        <td class="align-middle">${client.firstName}</td>
                        <td class="align-middle">${client.lastName}</td>
                        <td class="align-middle">${client.phone}</td>
                        <td class="align-middle">${client.email}</td>
                        <td class="align-middle">${client.balance}</td>
                        <td class="text-right">
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <input value="Orders" type="button" class="btn btn-primary" onclick="location.href='/order/${client.idClient}'"/>
                                <input value="Bills" type="button" class="btn btn-primary" onclick="location.href='/bill/${client.idClient}'"/>
                            </div>
                        </td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- JavaScript -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    <%@include file='js/bootstrap.min.js' %>
</script>
</body>
</html>