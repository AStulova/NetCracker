<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | 404 </title>
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

<div class="container">
    <div class="row h-100 align-items-center">
        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
            <div class="text-center">
                <h1 class="display-1 font-weight-bold">403</h1>
                <p class="h1">Access denied</p>
                <p class="h3 font-weight-normal mt-3 mb-4">You are not supposed to be here.</p>
                <button type="button" class="btn btn-primary btn-lg" onclick="history.back()">Come back </button>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    <%@include file='js/bootstrap.min.js' %>
</script></body>
</html>