<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Tariffs</title>
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
                            <a class="dropdown-item" href="/signout">Sign out</a>
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
                        <h1>Tariffs</h1>
                        <p class="lead"> </p>
                    </div>
                </div>
            </div>

            <!-- Table of services -->
            <table class="table table-borderless">
                <thead>
                    <tr>
                        <th scope="col">ID Tariff</th>
                        <th scope="col">Tariff name</th>
                        <th scope="col">Type</th>
                        <th scope="col">Price</th>
                        <th class="text-right"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tariff" items="${tariffList}">
                        <tr class="bg-light">
                            <td class="align-middle">${tariff.idTariff}</td>
                            <td class="align-middle">${tariff.nameTariff}</td>
                            <td class="align-middle">${tariff.typeTariff}</td>
                            <td class="align-middle">${tariff.priceTariff}</td>
                            <td class="text-right">
                                <c:if test="${!empty idOrder}">
                                    <input value="Add Tariff" type="button" onclick="location.href='/product/${idOrder}/add/${tariff.idTariff}'" class="btn btn-outline-primary" />
                                </c:if>
                                <c:if test="${empty idOrder}">
                                    <input value="Add Tariff" type="button" onclick="location.href='/product/add/${tariff.idTariff}'" class="btn btn-outline-primary" />
                                </c:if>
                            </td>
                        </tr>
                        <tr class="bg-white">
                            <td colspan="5"></td>
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