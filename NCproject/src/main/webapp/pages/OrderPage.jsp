<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Orders</title>
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
                    <li class="nav-item">
                        <a class="nav-link" href="/payment">Payment</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">Personal Information<span class="caret"></span></a>
                        <div class="dropdown-menu" aria-labelledby="download">
                            <a class="dropdown-item" href="/client">Info</a>
                            <a class="dropdown-item" href="/">Sign out</a>
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
                        <h1>Orders</h1>
                        <p class="lead"> </p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <div class="text-sm-right">
                            <input value="New Order" type="button" class="btn btn-primary btn-lg" onclick="location.href='/order/add/'" />
                        </div>
                    </div>
                </div>
            </div>

            <!-- Table of orders -->
            <table class="table table-borderless">
                <thead>
                <tr>
                    <th scope="col">ID Order</th>
                    <th scope="col">Order date</th>
                    <th scope="col">Order price</th>
                    <th scope="col">Status</th>
                    <th class="text-right"></th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orderList}">
                        <tr class="bg-light">
                            <td class="align-middle"><c:out value="${order[0]}"/></td>
                            <td class="align-middle"><c:out value="${order[1]}"/></td>
                            <td class="align-middle"> ??? </td>
                            <c:if test="${order[2] eq 'Saved'}">
                                <td class="align-middle">
                                    <span class="badge badge-warning">Saved</span>
                                </td>
                                <td class="text-right">
                                    <input value="Send" type="button" class="btn btn-primary" onclick="location.href='/order/send/${order[0]}'"/>
                                    <input value="Edit" type="button" class="btn btn-outline-primary" onclick="location.href='/product/${order[0]}'" />
                                </td>
                            </c:if>
                            <c:if test="${order[2] eq 'Sended'}">
                                <td class="align-middle">
                                    <span class="badge badge-success">Sended</span>
                                </td>
                                <td class="text-right">
                                    <input value="Cancel" type="button" class="btn btn-outline-primary" onclick="location.href='/order/delete/${order[0]}'" />
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