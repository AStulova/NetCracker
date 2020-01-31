<%@ page buffer="8192kb" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Products</title>
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
                        <c:if test="${productList[0].order.statusOrder eq 'Saved'}">
                            <h1>Edit Order <small>#${productList[0].order.idOrder}</small></h1>
                        </c:if>
                        <c:if test="${productList[0].order.statusOrder ne 'Saved'}">
                            <h1>Order <small>#${productList[0].order.idOrder}</small></h1>
                        </c:if>
                        <p class="lead"> </p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <c:if test="${productList[0].order.statusOrder eq 'Saved'}">
                            <div class="text-sm-right">
                                <input value="Add Tariff" type="button" class="btn btn-primary btn-lg" onclick="location.href='/${productList[0].order.idOrder}/add/tariff'" />
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>

            <!-- Table of products -->
            <table class="table table-borderless">
                <thead>
                <tr>
                    <th scope="col">Tariff name</th>
                    <th scope="col">Tariff type</th>
                    <th scope="col">SMS</th>
                    <th scope="col">Gb</th>
                    <th scope="col">Minutes</th>
                    <th scope="col">Speed</th>
                    <th scope="col">Price</th>
                    <c:if test="${productList[0].order.statusOrder eq 'Saved'}">
                        <th class="text-right"></th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr class="bg-light">
                        <td class="align-middle">${product.tariff.nameTariff}</td>
                        <td class="align-middle">${product.tariff.typeTariff}</td>
                        <td class="align-middle">${product.sms}</td>
                        <td class="align-middle">${product.gb}</td>
                        <td class="align-middle">${product.minute}</td>
                        <td class="align-middle">${product.speed}</td>
                        <td class="align-middle">${product.price}</td>
                        <c:if test="${productList[0].order.statusOrder eq 'Saved'}">
                            <td class="text-right">
                                <input value="Edit" type="button" class="btn btn-outline-primary" onclick="location.href='/product/${product.order.idOrder}/edit/${product.idProduct}'" />
                                <input value="Delete" type="button" class="btn btn-outline-primary" onclick="location.href='/product/${product.order.idOrder}/delete/${product.idProduct}'" />
                            </td>
                        </c:if>
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