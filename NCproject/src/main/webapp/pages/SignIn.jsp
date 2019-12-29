<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BilSYS | Sing In</title>
    <!-- Bootstrap -->
    <style>
        <%@include file='css/bootstrap.min.css' %>
        <%@include file='css/stylesheet.css' %>
    </style>
</head>
<body>
    <div class="container h-100">
        <div class="row align-items-center h-100">
            <div class="col-sm-10 col-md-8 col-lg-6 mx-auto my-4">
                <div class="text-center">
                    <h1 class="h2">Welcome back</h1>
                    <p class="lead">
                        Sign in to your account to continue
                    </p>
                </div>

                <div class="card bg-light">
                    <div class="card-body">
                        <div class="m-sm-4">
                            <form action="${var}" method="POST">
                                <div class="form-group">
                                    <label class="h5" for="email">Email</label>
                                    <input class="form-control form-control-lg" type="email" name="email" id="email" placeholder="Enter your email" required>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="password">Password</label>
                                    <input class="form-control form-control-lg" type="password" name="password" id="password" placeholder="Enter your password" required>
                                </div>
                                <label>
                                    Do you want to <a href="/signup">Sign Up?</a>
                                </label>
                                <div class="text-center mt-3">
                                    <input value="Sign in" type="button" class="btn btn-lg btn-primary" onclick="location.href=/client" />
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