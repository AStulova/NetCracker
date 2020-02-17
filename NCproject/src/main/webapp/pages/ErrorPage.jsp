<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | 403 </title>
    <!-- Bootstrap -->
    <style>
        <%@include file='css/bootstrap.min.css' %>
        <%@include file='css/stylesheet.css' %>
    </style>
</head>
<body>
    <div class="container">
        <div class="row h-100 align-items-center">
            <div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
                <div class="text-center">
                    <h1 class="display-1 font-weight-bold">${httpCode}</h1>
                    <p class="h1">${errorMessage}</p>
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
    </script>
</body>
</html>