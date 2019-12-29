<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BilSYS | Profile</title>
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
                        <h1>Personal Information</h1>
                        <p class="lead"> </p>
                    </div>
                </div>
            </div>

            <!-- ClientInfo -->
            <div class="card bg-light mb-4">
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label class="h5">Personal ID</label>
                            <p>46534635 </p>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label class="h5">First name</label>
                                <p>Name </p>
                            </div>
                            <div class="form-group col-md-6">
                                <label class="h5">Last name</label>
                                <p>LName </p>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label class="h5">Email</label>
                                <p>email@example.com</p>
                            </div>
                            <div class="form-group col-md-6">
                                <label class="h5">Phone</label>
                                <p>8910244357</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="h5">Balance</label>
                            <p>420.56 </p>
                        </div>
                    </form>
                </div>
            </div>

            <!-- Edit Client -->
            <div class="card bg-light">
                <div class="card-body">
                    <h4 class="card-title">Edit Information</h4>
                    <form action="${var}" method="POST">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label class="h5" for="firstName">First name</label>
                                <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First name" required pattern="^[A-Z][a-z]+$">
                            </div>
                            <div class="form-group col-md-6">
                                <label class="h5" for="lastName">Last name</label>
                                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name" required pattern="^[A-Z][a-z]+$">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label class="h5" for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Email" required>
                            </div>
                            <div class="form-group col-md-6">
                                <label class="h5" for="phone">Phone</label>
                                <input type="tel" class="form-control" name="phone" id="phone" placeholder="Phone" required>
                            </div>
                        </div>
                        <input value="Save changes" type="submit" class="btn btn-success" />
                    </form>
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