<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Bills </title>
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
                        <h1>Bill Information</h1>
                        <p class="lead"> </p>
                    </div>
                </div>
            </div>

            <!-- Bill Info -->
            <c:forEach var="bill" items="${billList}">
                <div class="card bg-light mb-4">
                    <div class="card-body m-sm-3 m-md-5">
                        <div class="mb-4">
                            Hi <strong>${bill.client.firstName} ${bill.client.lastName}</strong>,
                            <br>
                            This is the receipt for a payment of <strong>$${bill.total}</strong> (USD) you made to BillSYS.
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="text-muted">Payment No.</div>
                                <strong>${bill.idBill}</strong>
                            </div>
                            <div class="col-md-6 text-md-right">
                                <div class="text-muted">Payment Date</div>
                                <strong>${bill.dateBill}</strong>
                            </div>
                        </div>
                        <hr class="my-4">
                        <div class="row mb-4">
                            <div class="col-md-6">
                                <div class="text-muted">Client</div>
                                <strong>${bill.client.firstName} ${bill.client.lastName}</strong>
                                <p>
                                    ID: ${bill.client.idClient} <br>
                                    Phone: ${bill.client.phone}<br>
                                    Email: ${bill.client.email}
                                </p>
                            </div>
                        </div>

                        <!-- Table of products -->
                        <table class="table table-sm">
                            <thead>
                            <tr>
                                <th>ID order</th>
                                <th>Tariff</th>
                                <th>Type</th>
                                <th class="text-right">Amount</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="product" items="${productList}">
                                <tr>
                                    <td>${product[0]}</td>
                                    <td>${product[1]}</td>
                                    <td>${product[2]}</td>
                                    <td class="text-right">$${product[3]}</td>
                                </tr>
                            </c:forEach>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>Subtotal</th>
                                    <th class="text-right">$ ???</th>
                                </tr>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>Discount </th>
                                    <th class="text-right">${bill.discount}%</th>
                                </tr>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>Total </th>
                                    <th class="text-right">$${bill.total}</th>
                                </tr>
                            </tbody>
                        </table>

                        <div class="text-center">
                            <a href="#" class="btn btn-secondary" download>
                                Save this receipt
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- JavaScript -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        <%@include file='js/bootstrap.min.js' %>
    </script>
</body>
</html>