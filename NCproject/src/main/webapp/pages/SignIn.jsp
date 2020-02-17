<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Sing In</title>
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
                            <form:form method="POST" action="signin">
                                <c:if test="${not empty param.error}">
                                    <div class="alert alert-dismissible alert-primary">
                                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                                        <h4 class="alert-heading">Oops!</h4>
                                        <p class="mb-0"> Wrong email or password! Please try again...</p>
                                    </div>
                                </c:if>
                                <div class="form-group">
                                    <label class="h5" for="email">Email</label>
                                    <input class="form-control form-control-lg" type="text" name="email" id="email" placeholder="Enter your email" >
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="password">Password</label>
                                    <input class="form-control form-control-lg" type="password" name="password" id="password" placeholder="Enter your password" >
                                </div>
                                <div class="row">
                                    <div class="col-md-8 text-left">Do you want to <a href="/signup">Sign Up?</a> </div>
                                    <div class="col-md-4  text-right">...or return <a href="/">home</a></div>
                                </div>
                                <div class="text-center mt-3">
                                    <input value="Sign in" type="submit" class="btn btn-lg btn-primary"/>
                                </div>
                            </form:form>
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