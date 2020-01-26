<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Sing Up</title>
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
                            <form:form action="${var}" method="POST">
                                <div class="form-group">
                                    <label class="h5" for="firstName">First Name</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('firstName') ? 'is-invalid' : ''}" type="text" value="${not empty newClient.firstName ? newClient.firstName : ''}" name="firstName" id="firstName" placeholder="Enter your first name" required/>
                                    <c:if test="${not empty errorMessage.get('firstName')}">
                                        <div class="invalid-feedback">${errorMessage.get('firstName')}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="lastName">Last Name</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('lastName') ? 'is-invalid' : ''}" type="text" value="${not empty newClient.lastName ? newClient.lastName : ''}" name="lastName" id="lastName" placeholder="Enter your last name" required/>
                                    <c:if test="${not empty errorMessage.get('lastName')}">
                                        <div class="invalid-feedback">${errorMessage.get('lastName')}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="phone">Phone</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('phone') ? 'is-invalid' : ''}" type="tel" value="${not empty newClient.phone ? newClient.phone : ''}" name="phone" id="phone" placeholder="Enter your phone" required/>
                                    <c:if test="${not empty errorMessage.get('phone')}">
                                        <div class="invalid-feedback">${errorMessage.get('phone')}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="email">Email</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('email') ? 'is-invalid' : ''}" type="email" value="${not empty newClient.email ? newClient.email : ''}" name="email" id="email" placeholder="Enter your email" required/>
                                    <c:if test="${not empty errorMessage.get('email')}">
                                        <div class="invalid-feedback">${errorMessage.get('email')}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="password">Password</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('password') ? 'is-invalid' : ''}" type="password" name="password" id="password" placeholder="Enter your password" required>
                                    <c:if test="${not empty errorMessage.get('password')}">
                                        <div class="invalid-feedback">${errorMessage.get('password')}</div>
                                    </c:if>
                                </div>
                                <label>
                                    Do you want to <a href="/signin">Sign In?</a>
                                </label>
                                <div class="text-center mt-3">
                                   <input value="Sign Up" type="submit" class="btn btn-lg btn-primary"/>
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