<%--<%@ page buffer="8192kb" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Bills </title>
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
                        <h1>Bills Information</h1>
                        <p class="lead"> </p>
                    </div>
                </div>
            </div>

            <!-- Bill Info -->
            <c:if test="${empty billList}">
                <div class="container">
                    <div class="row h-50 align-items-center">
                        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
                            <div class="text-center">
                                <p class="lead text-secondary">You have no bills yet.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${!empty billList}">
                <c:forEach var="bill" items="${billList}">
                    <div class="card bg-light mb-4">
                        <div class="card-body m-sm-3 m-md-5">
                            <div class="mb-4">
                                Hi <strong>${client.firstName} ${client.lastName}</strong>,
                                <br>
                                This is the receipt for a payment of <strong>${bill.total} ₽</strong> (RUB) you made to BillSYS.
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted">Bill No.</div>
                                    <strong>${bill.idBill}</strong>
                                </div>
                                <div class="col-md-6 text-md-right">
                                    <div class="text-muted">Payment Date</div>
                                    <strong><fmt:formatDate pattern ="yyyy-MM-dd" value="${bill.dateBill}"/></strong>
                                </div>
                            </div>
                            <hr class="my-4">
                            <div class="row mb-4">
                                <div class="col-md-6">
                                    <div class="text-muted">Client</div>
                                    <strong>${client.firstName} ${client.lastName}</strong>
                                    <p>
                                        ID: ${client.idClient} <br>
                                        Phone: ${client.phone}<br>
                                        Email: ${client.email}
                                    </p>
                                </div>
                            </div>

                            <!-- Table of order's products -->
                            <table class="table table-sm">
                                <thead>
                                <tr>
                                    <th>ID order</th>
                                    <th>Order date</th>
                                    <th>Discount</th>
                                    <th>Tariff</th>
                                    <th class="text-right">Type</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="order" items="${orderList}">
                                        <c:if test="${order.statusOrder ne 0}">
                                            <c:set var="lastBill" value="${bill.dateBill.time - 2592000000}"/>
                                            <c:if test="${order.dateOrder le bill.dateBill or (order.dateCancel < bill.dateBill and order.dateCancel > lastBill)}">
                                                <tr>
                                                    <td>${order.idOrder}</td>
                                                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.dateOrder}"/></td>
                                                    <td>${order.discount}%</td>
                                                    <td>&nbsp;</td>
                                                    <td class="text-right">&nbsp;</td>
                                                </tr>
                                                <c:forEach var="product" items="${productList}">
                                                    <c:if test="${order.idOrder eq product[0]}">
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>${product[1]}</td>
                                                            <td class="text-right">${product[2]}</td>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${empty orderList}">
                                        <tr>
                                            <th>—</th>
                                            <th>—</th>
                                            <th>—</th>
                                            <th>—</th>
                                            <th class="text-right">—</th>
                                        </tr>
                                    </c:if>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                        <th class="text-right">&nbsp;</th>
                                    </tr>
                                    <tr>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                        <th>&nbsp;</th>
                                        <th>Total </th>
                                        <th class="text-right">${bill.total} ₽</th>
                                    </tr>
                                </tbody>
                            </table>

                            <div class="text-center">
                                <a href="#" class="btn btn-secondary" download>
                                    Save this bill
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <!-- JavaScript -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        <%@include file='js/bootstrap.min.js' %>
    </script>
</body>
</html>