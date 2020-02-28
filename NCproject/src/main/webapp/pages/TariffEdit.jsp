<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <c:if test="${empty tariff.idTariff or not empty errorMessage}">
        <title>BillSYS | Add Tariff</title>
    </c:if>
    <c:if test="${not empty tariff.idTariff and tariff.idTariff ne 0}">
        <title>BillSYS | Edit Tariff</title>
    </c:if>
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
        <a class="navbar-brand" href="/BillingSystem-1.0/client">BillSYS</a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive" style>
            <ul class="navbar-nav mr-auto">
                <c:if test="${role eq 'EMPLOYEE'}">
                    <li class="nav-item">
                        <a class="nav-link" href="/BillingSystem-1.0/clients">Clients</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="/BillingSystem-1.0/tariff">Tariffs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BillingSystem-1.0/order">Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BillingSystem-1.0/bill">Bills</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">Personal Information<span class="caret"></span></a>
                    <div class="dropdown-menu" aria-labelledby="download">
                        <a class="dropdown-item" href="/BillingSystem-1.0/client">Info</a>
                        <form:form action="/BillingSystem-1.0/logout" method="post">
                            <input class="dropdown-item" type="submit" value="Sign out">
                        </form:form>
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
                    <c:if test="${empty tariff.idTariff or not empty errorMessage}">
                        <h1>Add Tariff</h1>
                    </c:if>
                    <c:if test="${not empty tariff.idTariff and tariff.idTariff ne 0}">
                        <h1>Edit Tariff <small>#${tariff.idTariff}</small></h1>
                    </c:if>
                    <p class="lead"> </p>
                </div>
            </div>
        </div>

        <!-- Edit Tariff -->
        <div class="card bg-light">
            <div class="card-body">
                <form:form action="/BillingSystem-1.0/tariff/add" method="POST">
                    <c:if test="${not empty tariff.idTariff and tariff.idTariff ne 0}">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label class="h5" for="typeTariff">Tariff type</label>
                                <p>${tariff.typeTariff}</p>
                                <input type="hidden" name="typeTariff" value="${tariff.typeTariff}"/>
                            </div>
                        </div>
                        <input type="hidden" name="idTariff" value="${tariff.idTariff}"/>
                    </c:if>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="h5" for="nameTariff">Tariff name</label>
                            <c:set var="varName" value="${!empty tariff.nameTariff ? tariff.nameTariff : not empty newTariff.nameTariff ? newTariff.nameTariff : ''}" />
                            <input type="text" class="form-control ${!empty errorMessage.get('nameTariff') ? 'is-invalid' : ''}" name="nameTariff" id="nameTariff" value="${varName}" placeholder="${empty varName ? 'Enter name' : ''}" />
                            <c:if test="${not empty errorMessage.get('nameTariff')}">
                                <div class="invalid-feedback">${errorMessage.get('nameTariff')}</div>
                            </c:if>
                        </div>
                        <c:if test="${empty tariff.idTariff or not empty errorMessage}">
                        <div class="form-group col-md-6">
                            <label class="h5" for="typeTariff">Tariff type</label>
                            <select class="form-control" name="typeTariff" id="typeTariff" required>
                                <c:if test="${!empty tariff.typeTariff}">
                                    <option selected>${tariff.typeTariff}</option>
                                </c:if>
                                <option>Mobile connection and Internet</option>
                                <option>Internet</option>
                                <option>Phone</option>
                            </select>
                        </div>
                        </c:if>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label class="h5" for="priceTariff">Tariff price</label>
                            <c:set var="varPrice" value="${!empty tariff.priceTariff ? tariff.priceTariff : not empty newTariff.priceTariff ? newTariff.priceTariff : ''}" />
                            <input type="text" class="form-control ${!empty errorMessage.get('priceTariff') ? 'is-invalid' : ''}" name="priceTariff" id="priceTariff" value="${varPrice}" placeholder="${empty varPrice ? 'Enter price' : ''}" />
                            <c:if test="${not empty errorMessage.get('priceTariff')}">
                                <div class="invalid-feedback">${errorMessage.get('priceTariff')}</div>
                            </c:if>
                        </div>
                    </div>
                    <input value="${not empty tariff.idTariff and tariff.idTariff ne 0 ? 'Edit' : 'Add'}" type="submit" class="btn btn-success" />
                    <button type="button" class="btn btn-secondary" onclick="history.back()">Cancel</button>
                </form:form>
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