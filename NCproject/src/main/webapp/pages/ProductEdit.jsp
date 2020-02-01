<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <c:if test="${empty product.idProduct}">
        <title>BillSYS | Add Product</title>
    </c:if>
    <c:if test="${!empty product.idProduct}">
        <title>BillSYS | Edit Product</title>
    </c:if>
    <!-- Bootstrap -->
    <style>
        <%@include file='css/bootstrap.min.css' %>
        <%@include file='css/stylesheet.css' %>
    </style>
</head>
<body>
    <c:if test="${product.idProduct eq 0}">
        <c:url value="/product/${product.order.idOrder}/add/${product.tariff.idTariff}" var="var"/>
    </c:if>
    <c:if test="${product.idProduct ne 0}">
        <c:url value="/product/${product.order.idOrder}/edit" var="var"/>
    </c:if>

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
                        <c:if test="${product.idProduct eq 0}">
                            <h1>Add Product</h1>
                        </c:if>
                        <c:if test="${product.idProduct ne 0}">
                            <h1>Edit Product</h1>
                        </c:if>
                        <p class="lead"> </p>
                    </div>
                </div>
            </div>

            <!-- Add/Edit Product -->
            <div class="card bg-light mb-4">
                <div class="card-body">
                    <form:form action="${var}" method="POST">
                        <input type="hidden" name="order.idOrder" value="${product.order.idOrder}">
                        <input type="hidden" name="order.client.idClient" value="${product.order.client.idClient}">
                        <input type="hidden" name="tariff.idTariff" value="${product.tariff.idTariff}">
                        <c:if test="${product.idProduct ne 0}">
                            <input type="hidden" name="idProduct" value="${product.idProduct}">
                            <input type="hidden" name="id" value="${product.idProduct}">
                        </c:if>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label class="h5">Name</label>
                                    <p>${product.tariff.nameTariff}</p>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="h5">Type</label>
                                    <p>${product.tariff.typeTariff}</p>
                                </div>
                            </div>
                            <c:if test="${product.tariff.typeTariff eq 'Mobile connection and Internet'}">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="sms">Number of SMS</label>
                                        <select class="form-control" name="sms" id="sms" required>
                                            <c:if test="${product.idProduct ne 0}">
                                                <option selected>${product.sms}</option>
                                            </c:if>
                                            <option>200</option>
                                            <option>400</option>
                                            <option>600</option>
                                            <option>800</option>
                                            <option>1000</option>
                                            <option>1200</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3"> </div>
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="minute">Number of minutes</label>
                                        <select class="form-control" name="minute" id="minute" required>
                                            <c:if test="${product.idProduct ne 0}">
                                                <option selected>${product.minute}</option>
                                            </c:if>
                                            <option>300</option>
                                            <option>600</option>
                                            <option>900</option>
                                            <option>1200</option>
                                            <option>1500</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="gb">Number of Gb</label>
                                        <select class="form-control" name="gb" id="gb" required>
                                            <c:if test="${product.idProduct ne 0}">
                                                <option selected>${product.gb}</option>
                                            </c:if>
                                            <option>10</option>
                                            <option>15</option>
                                            <option>20</option>
                                            <option>25</option>
                                            <option>30</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3"> </div>
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="speed">Maximum speed (Mb/s)</label>
                                        <select class="form-control" name="speed" id="speed" required>
                                            <c:if test="${product.idProduct ne 0}">
                                                <option selected>${product.speed}</option>
                                            </c:if>
                                            <option>10</option>
                                            <option>30</option>
                                            <option>60</option>
                                            <option>100</option>
                                        </select>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${product.tariff.typeTariff eq 'Internet'}">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="gb">Number of Gb</label>
                                        <select class="form-control" name="gb" id="gb" required>
                                            <c:if test="${product.idProduct ne 0}">
                                                <option selected>${product.gb}</option>
                                            </c:if>
                                            <option>1000</option>
                                            <option>5000</option>
                                            <option>10000</option>
                                            <option>15000</option>
                                            <option>20000</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3"></div>
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="speed">Maximum speed (Mb/s)</label>
                                        <select class="form-control" name="speed" id="speed" required>
                                        <c:if test="${product.idProduct ne 0}">
                                            <option selected>${product.speed}</option>
                                        </c:if>
                                            <option>30</option>
                                            <option>60</option>
                                            <option>100</option>
                                            <option>300</option>
                                        </select>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${product.tariff.typeTariff eq 'Phone'}">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="sms">Number of SMS</label>
                                        <select class="form-control" name="sms" id="sms" required>
                                            <c:if test="${product.idProduct ne 0}">
                                                <option selected>${product.sms}</option>
                                            </c:if>
                                            <option>200</option>
                                            <option>400</option>
                                            <option>600</option>
                                            <option>800</option>
                                            <option>1000</option>
                                            <option>1200</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3"></div>
                                    <div class="form-group col-md-3">
                                        <label class="h5" for="minute">Number of minutes</label>
                                        <select class="form-control" name="minute" id="minute" required>
                                            <c:if test="${product.idProduct ne 0}">
                                                <option selected>${product.minute}</option>
                                            </c:if>
                                            <option>300</option>
                                            <option>600</option>
                                            <option>900</option>
                                            <option>1200</option>
                                            <option>1500</option>
                                        </select>
                                    </div>
                                </div>
                            </c:if>
                            <input type="submit" class="btn btn-success" value="Save"/>
                            <button type="button" class="btn btn-outline-secondary" onclick="history.back()">Cancel</button>
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