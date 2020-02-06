<%@ page buffer="8192kb" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <a class="navbar-brand" href="/client">BillSYS</a>
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive" style>
                <ul class="navbar-nav mr-auto">
                    <c:if test="${role eq 'EMPLOYEE'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/clients">Clients</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="/tariff">Tariffs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/order">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/bill">Bills</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">Personal Information<span class="caret"></span></a>
                        <div class="dropdown-menu" aria-labelledby="download">
                            <a class="dropdown-item" href="/client">Info</a>
                            <a class="dropdown-item" href="/signout">Sign out</a>
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
                        <h1>Bill Information</h1>
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
                    <%--Error message--%>
                    <c:if test="${curBill.idBill eq bill.idBill}">
                        <div class="alert alert-dismissible alert-warning">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <h4 class="alert-heading">Warning!</h4>
                            <p class="mb-0">
                                Changes wasn't accepted for Bill #${curBill.idBill}. <br>
                                ${errorMessage.get('discount')}
                            </p>
                        </div>
                    </c:if>

                    <div class="card bg-light mb-4">
                        <div class="card-body m-sm-3 m-md-5">
                            <div class="mb-4">
                                Hi <strong>${client.firstName} ${client.lastName}</strong>,
                                <br>
                                This is the receipt for a payment of <strong>$${bill.total}</strong> (USD) you made to BillSYS.
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted">Bill No.</div>
                                    <strong>${bill.idBill}</strong>
                                </div>
                                <div class="col-md-6 text-md-right">
                                    <div class="text-muted">Payment Date</div>
                                    <strong>${bill.dateBill}</strong>
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
                                    <th>Tariff</th>
                                    <th class="text-right">Type</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="order" items="${orderList}">
                                    <c:if test="${order.statusOrder eq 'Sended'}">
                                        <c:if test="${order.dateOrder le bill.dateBill}">
                                            <tr>
                                                <td>${order.idOrder}</td>
                                                <td>${order.dateOrder}</td>
                                                <td>&nbsp;</td>
                                                <td class="text-right">&nbsp;</td>
                                            </tr>
                                            <c:forEach var="product" items="${productList}">
                                                <c:if test="${order.idOrder eq product[0]}">
                                                    <tr>
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
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th class="text-right">&nbsp;</th>
                                </tr>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>Subtotal</th>
                                    <th class="text-right">$${bill.subtotal}</th>
                                </tr>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>Discount </th>
                                    <th class="text-right">
                                            ${bill.discount}%
                                        <c:if test="${role eq 'EMPLOYEE'}">
                                            <button type="button" class="btn btn-default btn-xs" data-toggle="modal" data-target="#discount-modal" >
                                                <%--<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>--%>
                                                <span aria-hidden="true">✍</span>
                                            </button>
                                        </c:if>
                                    </th>
                                </tr>
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>Total </th>
                                    <th class="text-right">$${bill.total}</th>
                                </tr>
                                </tbody>
                            </table>

                            <div class="text-center">
                                <a href="#" class="btn btn-secondary" download>
                                    Save this receipt
                                </a>
                            </div>
                        </div>
                    </div>

                    <%--Discount modal--%>
                    <div class="modal fade" id="discount-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="exampleModalLabel">Bill #${bill.idBill}</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form:form action="/bill/edit" method="POST">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label for="discount" class="text-left">Set new discount:</label>
                                            <input type="number" class="form-control" id="discount" name="discount" value="${bill.discount}">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" id="idBill" name="idBill" value="${bill.idBill}">
                                        <input type="hidden" id="client" name="client.idClient" value="${bill.client.idClient}">
<%--
                                        <input type="hidden" id="dateBill" name="dateBill" value="${bill.dateBill}">
                                        <input type="hidden" id="subtotal" name="subtotal" value="${bill.subtotal}">
                                        <input type="hidden" id="total" name="total" value="${bill.total}">
--%>
                                        <input type="submit" class="btn btn-primary" value="Confirm">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </form:form>
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