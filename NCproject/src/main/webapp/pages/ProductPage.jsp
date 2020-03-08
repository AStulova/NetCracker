<%--<%@ page buffer="8192kb" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>BillSYS | Products</title>
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
                            <form:form action="/logout" method="post">
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
                        <c:if test="${productList[0].order.statusOrder eq 0}">
                            <h1>Edit Order <small>#${productList[0].order.idOrder}</small></h1>
                        </c:if>
                        <c:if test="${productList[0].order.statusOrder ne 0}">
                            <h1>Order
                                <c:if test="${!empty productList}">
                                <small>#${productList[0].order.idOrder}</small>
                                </c:if>
                            </h1>
                        </c:if>
                        <p class="lead"> </p>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <c:if test="${productList[0].order.statusOrder eq 0}">
                            <div class="text-sm-right">
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <input value="Add Tariff" type="button" class="btn btn-primary btn-lg" onclick="location.href='/${productList[0].order.idOrder}/add/tariff'" />
                                    <input value="Back" type="button" class="btn btn-secondary" onclick="history.back()"/>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${productList[0].order.statusOrder ne 0}">
                            <div class="text-sm-right">
                                <input value="Back" type="button" class="btn btn-secondary btn-lg" onclick="history.back()"/>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>

            <!-- Order Info -->
            <c:if test="${not empty order}">
                <div class="card bg-light mb-4">
                    <div class="card-body">
                        <form:form action="/product/edit/discount" method="POST">
                            <input type="hidden" name="idOrder" value="${order.idOrder}"/>
                            <input type="hidden" name="client.idClient" value="${order.client.idClient}">
                            <input type="hidden" name="dateOrder" value="${order.dateOrder}"/>
                            <input type="hidden" name="dateCancel" value="${order.dateCancel}"/>
                            <input type="hidden" name="priceOrder" value="${order.priceOrder}"/>
                            <input type="hidden" name="statusOrder" value="${order.statusOrder}"/>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label class="h5">Order date</label>
                                    <div>
                                        <c:if test="${order.dateOrder eq null}">
                                            —
                                        </c:if>
                                        <c:if test="${order.dateOrder ne null}">
                                            <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.dateOrder}"/>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="h5">Cancel date</label>
                                    <p>
                                        <c:if test="${order.dateCancel eq null}">
                                            —
                                        </c:if>
                                        <c:if test="${order.dateCancel ne null}">
                                            <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.dateCancel}"/>
                                        </c:if>
                                    </p>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label class="h5">Order price</label>
                                    <p>${order.priceOrder} ₽</p>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="h5">Status</label>
                                    <div>
                                        <c:if test="${order.statusOrder eq 0}">
                                            <span class="badge badge-warning">Saved</span>
                                        </c:if>
                                        <c:if test="${order.statusOrder eq 1}">
                                            <span class="badge badge-success">Active</span>
                                        </c:if>
                                        <c:if test="${order.statusOrder eq 2}">
                                            <span class="badge badge-secondary">Canceled</span>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-2">
                                    <label class="h5" for="discount">Discount</label>
                                    <c:if test="${role eq 'EMPLOYEE' and order.statusOrder ne 2}">
                                        <input type="number"  min="0" max="100" class="form-control ${not empty errorMessage.get('discount') ? 'is-invalid' : ''}" placeholder="0" name="discount" id="discount" value="${not empty newDiscount ? newDiscount : order.discount}"/>
                                        <c:if test="${not empty errorMessage.get('discount')}">
                                            <div class="invalid-feedback">${errorMessage.get('discount')}</div>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${role eq 'USER' or order.statusOrder eq 2}">
                                        <p>${order.discount}%</p>
                                    </c:if>
                                </div>
                            </div>
                            <input value="Edit discount" type="submit" class="btn btn-success" />
                        </form:form>
                    </div>
                </div>
            </c:if>

            <!-- Table of products -->
            <c:if test="${empty productList}">
                <div class="container">
                    <div class="row h-50 align-items-center">
                        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto">
                            <div class="text-center">
                                <p class="lead text-secondary">There are no products.</p>
                                <p class="lead text-secondary">You can return to <a href="/order">your orders</a>.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${!empty productList}">
                <table class="table table-borderless">
                    <thead>
                    <tr>
                        <th scope="col">Tariff name</th>
                        <th scope="col">Tariff type</th>
                        <th scope="col">SMS</th>
                        <th scope="col">Gb</th>
                        <th scope="col">Minutes</th>
                        <th scope="col">Speed</th>
                        <th scope="col">Price</th>
                        <c:if test="${productList[0].order.statusOrder eq 0}">
                            <th class="text-right"></th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${productList}">
                        <tr class="bg-light">
                            <td class="align-middle">${product.tariff.nameTariff}</td>
                            <td class="align-middle">${product.tariff.typeTariff}</td>
                            <td class="align-middle">${product.sms}</td>
                            <td class="align-middle">${product.gb}</td>
                            <td class="align-middle">${product.minute}</td>
                            <td class="align-middle">${product.speed}</td>
                            <td class="align-middle">${product.price}</td>
                            <c:if test="${productList[0].order.statusOrder eq 0}">
                                <td class="text-right">
                                    <input value="Edit" type="button" class="btn btn-outline-primary" onclick="location.href='/product/${product.order.idOrder}/edit/${product.idProduct}'" />
                                    <input value="Delete" type="button" class="btn btn-outline-primary" onclick="location.href='/product/${product.order.idOrder}/delete/${product.idProduct}'" />
                                </td>
                            </c:if>
                        </tr>
                        <tr class="bg-white">
                            <td colspan="5"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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