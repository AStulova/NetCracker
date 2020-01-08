<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BilSYS | Home</title>
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
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">Personal Information<span class="caret"></span></a>
                        <div class="dropdown-menu" aria-labelledby="download">
                            <a class="dropdown-item" href="/signin">Sign In</a>
                            <a class="dropdown-item" href="/signup">Sign Up</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Page -->
    <div class="intro-content bg-primary py-6 text-center text-white">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-12 col-sm-10 col-md-8 col-lg-6 mx-auto text-center">
                    <h1 class="my-3 display-4 d-none d-lg-inline-block">Welcome in BillSYS!</h1>
                    <span class="h1 my-3 d-inline-block d-lg-none"></span>
                    <p class="lead mb-3">Before start you need to...</p>
                    <a class="btn btn-success btn-lg mr-lg-2 my-1" href="/signin" role="button">Sign In</a>
                    <a class="btn btn-success btn-lg my-1" href="/signup" role="button">Sign Up</a>
                </div>
            </div>
        </div>
    </div>

   <%-- <div class="bg-white py-5">
        <div class="container">
            <div class="text-center mb-5">
                <h3>You can see</h3>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-6 col-lg-4">
                            <a class="card bg-light mb-4" href="#">
                                <div class="card-body my-3 text-center">
                                    <i class="far fa-3x fa-user-circle mb-2 text-primary"></i>
                                    <h5 class="mb-0 font-weight-light">Account</h5>
                                </div>
                            </a>
                        </div>
                        <div class="col-6 col-lg-4">
                            <a class="card bg-light mb-4" href="#">
                                <div class="card-body my-3 text-center">
                                    <i class="far fa-3x fa-chart-bar mb-2 text-warning"></i>
                                    <h5 class="mb-0 font-weight-light">Analytics</h5>
                                </div>
                            </a>
                        </div>
                        <div class="col-6 col-lg-4">
                            <a class="card bg-light mb-4" href="#">
                                <div class="card-body my-3 text-center">
                                    <i class="far fa-3x fa-money-bill-alt mb-2 text-info"></i>
                                    <h5 class="mb-0 font-weight-light">Billing</h5>
                                </div>
                            </a>
                        </div>
                        <div class="col-6 col-lg-4">
                            <a class="card bg-light mb-4" href="#">
                                <div class="card-body my-3 text-center">
                                    <i class="far fa-3x fa-file-code mb-2 text-danger"></i>
                                    <h5 class="mb-0 font-weight-light">Development</h5>
                                </div>
                            </a>
                        </div>
                        <div class="col-6 col-lg-4">
                            <a class="card bg-light mb-4" href="#">
                                <div class="card-body my-3 text-center">
                                    <i class="fas fa-3x fa-project-diagram  mb-2 text-success"></i>
                                    <h5 class="mb-0 font-weight-light">Projects</h5>
                                </div>
                            </a>
                        </div>
                        <div class="col-6 col-lg-4">
                            <a class="card bg-light mb-4" href="#">
                                <div class="card-body my-3 text-center">
                                    <i class="fas fa-3x fa-unlock-alt mb-2 text-primary"></i>
                                    <h5 class="mb-0 font-weight-light">Security</h5>
                                </div>
                            </a>
                        </div>
                    </div><!-- /.row -->
                </div>
            </div><!-- /.row -->
            <div class="row justify-content-center">

            </div>
            <div class="row justify-content-center">

            </div><!-- /.row -->
        </div>
    </div>--%>


    <!-- JavaScript -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        <%@include file='js/bootstrap.min.js' %>
    </script>
</body>
</html>