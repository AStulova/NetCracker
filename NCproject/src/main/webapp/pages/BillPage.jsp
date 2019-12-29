<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BilSYS | Bills </title>
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
            <div class="card bg-light">
                <div class="card-body m-sm-3 m-md-5">
                    <div class="mb-4">
                        Hi <strong>Jane Roe</strong>,
                        <br>
                        This is the receipt for a payment of <strong>$268.00</strong> (USD) you made to BilSYS.
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="text-muted">Payment No.</div>
                            <strong>732047036</strong>
                        </div>
                        <div class="col-md-6 text-md-right">
                            <div class="text-muted">Payment Date</div>
                            <strong>Apr 13, 2018 - 02:55 pm</strong>
                        </div>
                    </div>
                    <hr class="my-4">
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="text-muted">Client</div>
                            <strong>Jane Roe</strong>
                            <p>
                                ID: 10011 <br>
                                Phone: 8910244357<br>
                                Email: john.roe@gmail.com
                            </p>
                        </div>
                    </div>

                    <table class="table table-sm">
                        <thead>
                        <tr>
                            <th>Tariff</th>
                            <th>Type</th>
                            <th>Quantity</th>
                            <th class="text-right">Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Productivity</td>
                            <td>Internet</td>
                            <td>20</td>
                            <td class="text-right">$250.00</td>
                        </tr>
                        <tr>
                            <td>Social</td>
                            <td>Minutes and SMS</td>
                            <td>500</td>
                            <td class="text-right">$250.00</td>
                        </tr>
                        <tr>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                            <th>Subtotal</th>
                            <th class="text-right">$500.00</th>
                        </tr>
                        <tr>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                            <th>Discount </th>
                            <th class="text-right">5%</th>
                        </tr>
                        <tr>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                            <th>Total </th>
                            <th class="text-right">$475.00</th>
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
        </div>
    </div>

    <!-- JavaScript -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        <%@include file='js/bootstrap.min.js' %>
    </script>
</body>
</html>