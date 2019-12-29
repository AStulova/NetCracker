<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BilSYS | Add/Edit Order</title>
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
            <a class="navbar-brand" href="/client">BilSYS</a>
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
                        <h1>Add/Edit Order</h1>
                        <p class="lead"> </p>
                    </div>
                </div>
            </div>

            <!-- Add/Edit Order -->
            <div class="card bg-light mb-4">
                <div class="card-body">
                    <form action="${var}" method="POST">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label class="h5">Tariff name</label>
                                <p>Smart</p>
                            </div>
                            <div class="form-group col-md-6">
                                <label class="h5">Type</label>
                                <p>Internet</p>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label class="h5">Price for 1 SMS/Gb/min</label>
                                <p>15.50</p>
                            </div>
                            <div class="form-group col-md-3">
                                <label class="h5" for="numberOrder">Number of SMS/Gb/min</label>
                                <select class="form-control" id="numberOrder">
                                    <option>100</option>
                                    <option>200</option>
                                    <option>300</option>
                                    <option>500</option>
                                    <option>600</option>
                                    <option>700</option>
                                </select>
                            </div>
                        </div>
                        <input type="submit" class="btn btn-success" value="Send" />
                        <input type="submit" class="btn btn-warning" value="Save" />
                        <button type="button" class="btn btn-outline-secondary" onclick="history.back()">Cancel</button>
                    </form>
                </div>
            </div>

            <!-- Table of orders -->
            <table class="table table-borderless">
                <thead>
                <tr>
                    <th scope="col">ID Order</th>
                    <th scope="col">Tariff name</th>
                    <th scope="col">Tariff type</th>
                    <th scope="col">Number of SMS/Gb/min</th>
                    <th scope="col">Order date</th>
                    <th scope="col">Order price</th>
                    <th scope="col">Status</th>
                    <th class="text-right"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orderList}">
                    <tr class="bg-light">
                        <td class="align-middle">${order.idOrder}</td>
                        <td class="align-middle">Productivity</td>
                        <td class="align-middle">Internet</td>
                        <td class="align-middle">${order.numberOrder}</td>
                        <td class="align-middle">${order.dateOrder}</td>
                        <td class="align-middle">250.00</td>
                        <c:if test="${order.statusOrder eq 'Saved'}">
                            <td class="align-middle">
                                <span class="badge badge-warning">Saved</span>
                            </td>
                            <td class="text-right">
                                <input value="Send" type="button" class="btn btn-primary" onclick="location.href='/tariff-send${order.idOrder}'"/>
                                <input value="Edit" type="button" class="btn btn-outline-primary" onclick="location.href='/tariff-edit${order.idOrder}'" />
                            </td>
                        </c:if>
                        <c:if test="${order.statusOrder eq 'Sended'}">
                            <td class="align-middle">
                                <span class="badge badge-success">Sended</span>
                            </td>
                            <td class="text-right">
                                <input value="Delete" type="button" class="btn btn-outline-primary" onclick="location.href='/tariff-delete${order.idOrder}'" />
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