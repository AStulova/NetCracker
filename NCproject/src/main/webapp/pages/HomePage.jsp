<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Home</title>
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
            <a class="navbar-brand" href="/BillingSystem-1.0/">BillSYS</a>
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>

    <!-- Page -->
    <div class="intro-content bg-primary py-6 text-center text-white">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-12 col-sm-10 col-md-8 col-lg-6 mx-auto text-center">
                    <h1 class="my-3 display-4 d-lg-inline-block">Welcome in BillSYS!</h1>
                    <span class="h1 my-3 d-inline-block d-lg-none"></span>
                    <p class="lead mb-3">Before start you need to...</p>
                    <a class="btn btn-success btn-lg mr-lg-2 my-1" href="/BillingSystem-1.0/signin" role="button">Sign In</a>
                    <a class="btn btn-success btn-lg my-1" href="/BillingSystem-1.0/signup" role="button">Sign Up</a>
                </div>
            </div>
        </div>
    </div>

    <main class="main" role="main">
        <div class="bg-white py-7">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 mx-auto">
                        <div class="row">
                            <div class="col-md-4 ml-auto">
                                <h2>Be in touch!</h2>
                            </div>
                            <div class="col-md-6 mr-auto">
                                <p class="lead text-dark">
                                    Use mobile and Internet services and record your expenses for communication.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- JavaScript -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        <%@include file='js/bootstrap.min.js' %>
    </script>
</body>
</html>