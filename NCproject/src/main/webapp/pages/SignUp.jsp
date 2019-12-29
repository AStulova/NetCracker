<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BilSYS | Sing Up</title>
    <!-- Bootstrap -->
    <style>
        <%@include file='css/bootstrap.min.css' %>
        <%@include file='css/stylesheet.css' %>
    </style></head>
<body>
    <div class="container h-100">
        <div class="row align-items-center h-100">
            <div class="col-sm-10 col-md-8 col-lg-6 mx-auto my-4">
                <div class="text-center">
                    <h1 class="h2">Sign Up</h1>
                    <p class="lead">
                        Get started with us now
                    </p>
                </div>
                <div class="card bg-light">
                    <div class="card-body">
                        <div class="m-sm-4">
                            <form action="${var}" method="POST">
                                <input type="hidden" name="id" value="${client.idClient}">
                                <div class="form-group">
                                    <label class="h5" for="firstName">First Name</label>
                                    <input class="form-control form-control-lg" type="text" name="firstName" id="firstName" placeholder="Enter your first name" required pattern="^[A-Z][a-z]+$">
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="lastName">Last Name</label>
                                    <input class="form-control form-control-lg" type="text" name="lastName" id="lastName" placeholder="Enter your last name" required pattern="^[A-Z][a-z]+$">
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="phone">Phone</label>
                                    <input class="form-control form-control-lg" type="tel" name="phone" id="phone" placeholder="Enter your phone" required>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="email">Email</label>
                                    <input class="form-control form-control-lg" type="email" name="email" id="email" placeholder="Enter your email" required>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="password">Password</label>
                                    <input class="form-control form-control-lg" type="password" name="password" id="password" placeholder="Enter your password" required>
                                </div>
                                <label>
                                    Do you want to <a href="/">Sign In?</a>
                                </label>
                                <div class="text-center mt-3">
                                   <input value="Sign Up" type="submit" class="btn btn-lg btn-primary" onclick="location.href=/client" />
                                </div>
                            </form>
                        </div>
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