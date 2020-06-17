<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <c:if test="${not empty curClient.idClient and curClient.idClient ne 0}">
        <title>BillSYS | Edit User</title>
    </c:if>
    <c:if test="${empty curClient.idClient or curClient.idClient eq 0}">
        <title>BillSYS | Add User</title>
    </c:if>

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
                    <c:if test="${not empty curClient.idClient and curClient.idClient ne 0}">
                        <h1 class="h2">Edit User</h1>
                    </c:if>
                    <c:if test="${empty curClient.idClient or curClient.idClient eq 0}">
                        <h1 class="h2">New User</h1>
                    </c:if>
                </div>
                <div class="card bg-light">
                    <div class="card-body">
                        <div class="m-sm-4">
                            <c:if test="${not empty errorMessage.get('emailRepeat')}">
                                <div class="alert alert-dismissible alert-primary">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <h4 class="alert-heading">Oops!</h4>
                                    <p class="mb-0">${errorMessage.get('emailRepeat')}</p>
                                </div>
                            </c:if>
                            <form:form action="/signup" method="POST">
                                <div class="form-group">
                                    <label class="h5" for="firstName">First Name</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('firstName') ? 'is-invalid' : ''}" type="text" value="${not empty curClient.firstName ? curClient.firstName : ''}" name="firstName" id="firstName" placeholder="Enter first name"/>
                                    <c:if test="${not empty errorMessage.get('firstName')}">
                                        <div class="invalid-feedback">${errorMessage.get('firstName')}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="lastName">Last Name</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('lastName') ? 'is-invalid' : ''}" type="text" value="${not empty curClient.lastName ? curClient.lastName : ''}" name="lastName" id="lastName" placeholder="Enter last name"/>
                                    <c:if test="${not empty errorMessage.get('lastName')}">
                                        <div class="invalid-feedback">${errorMessage.get('lastName')}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="phone">Phone</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('phone') ? 'is-invalid' : ''}" type="text" value="${not empty curClient.phone ? curClient.phone : ''}" name="phone" id="phone" placeholder="Enter phone"/>
                                    <c:if test="${not empty errorMessage.get('phone')}">
                                        <div class="invalid-feedback">${errorMessage.get('phone')}</div>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label class="h5" for="email">Email</label>
                                    <input class="form-control form-control-lg ${not empty errorMessage.get('email') ? 'is-invalid' : ''}" type="text" value="${not empty curClient.email ? curClient.email : ''}" name="email" id="email" placeholder="Enter email"/>
                                    <c:if test="${not empty errorMessage.get('email')}">
                                        <div class="invalid-feedback">${errorMessage.get('email')}</div>
                                    </c:if>
                                </div>
                                <c:if test="${not empty curClient.idClient and curClient.idClient ne 0}">
                                    <input type="hidden" name="password" value="${curClient.password}">
                                    <input type="hidden" name="idClient" value="${curClient.idClient}">
                                </c:if>
                                <c:if test="${empty curClient.idClient or curClient.idClient eq 0}">
                                    <div class="form-group">
                                        <label class="h5" for="password">Password</label>
                                        <input class="form-control form-control-lg ${not empty errorMessage.get('password') ? 'is-invalid' : ''}" type="password" name="password" id="password" placeholder="Enter password">
                                        <c:if test="${not empty errorMessage.get('password')}">
                                            <div class="invalid-feedback">${errorMessage.get('password')}</div>
                                        </c:if>
                                    </div>
                                </c:if>
                                <div class="form-group">
                                    <label class="h5" for="role">Role</label>
                                    <select class="form-control" name="role" id="role">
                                        <c:if test="${not empty curClient.idClient and curClient.idClient ne 0}">
                                            <option selected>${curClient.role}</option>
                                        </c:if>
                                        <c:if test="${empty curClient.idClient or curClient.idClient eq 0}">
                                            <option selected>USER</option>
                                        </c:if>
                                        <option>USER</option>
                                        <option>EMPLOYEE</option>
                                        <option>MANAGER</option>
                                        <option>ADMIN</option>
                                    </select>
                                </div>
                                <div>
                                    <div class="text-right">Back to <a href="/users">users</a></div>
                                </div>
                                <div class="text-center mt-3">
                                   <input value="Confirm" type="submit" class="btn btn-lg btn-primary"/>
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