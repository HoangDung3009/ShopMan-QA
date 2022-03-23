<%@ page import="com.example.ShopManWebApp.model.ProductStat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.ShopManWebApp.dao.ProductDAO" %>
<%@ page import="com.example.ShopManWebApp.model.Product" %>
<%@ page import="com.example.ShopManWebApp.dao.OrderDetailDAO" %>
<%@ page import="com.example.ShopManWebApp.model.OrderDetail" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/20/2022
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Product Detail</title>

  <!-- Favicon -->
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/admin_assets/images/logo/favicon.png">

  <!-- page css -->

  <!-- Core css -->
  <link href="<%=request.getContextPath()%>/admin_assets/css/app.min.css" rel="stylesheet">

</head>

<body>
<div class="app">
  <div class="layout">
    <!-- Header START -->
    <%@include file="/layout/header2.jsp" %>
    <!-- Header END -->

    <!-- Side Nav START -->
    <%@include file="/layout/sidenav.jsp" %>
    <!-- Side Nav END -->

    <!-- Page Container START -->
    <div class="page-container">
  <%ProductDAO productDAO = new ProductDAO();
    int id = Integer.parseInt(request.getParameter("prod_id"));
    Product p = productDAO.getProductById(id);
    DecimalFormat df = new DecimalFormat("#,###.##");
  %>

      <!-- Content Wrapper START -->
      <div class="main-content">
        <div class="page-header">
          <h2 class="header-title">Statistics</h2>
          <div class="header-sub-title">
            <nav class="breadcrumb breadcrumb-dash">
              <a href="#" class="breadcrumb-item"><i class="anticon anticon-home m-r-5"></i>Statistics</a>
              <a class="breadcrumb-item" href="#">Product Statistics</a>
              <a class="breadcrumb-item" href="#">Product Details</a>
            </nav>
          </div>
        </div>
        <div class="page-header no-gutters has-tab">
          <div class="d-md-flex m-b-15 align-items-center justify-content-between">
            <div class="media align-items-center m-b-15">
              <div class="avatar avatar-image rounded" style="height: 70px; width: 70px">
                <img src="<%=request.getContextPath()%>/assets/images/product/<%=p.getPicture()%>" alt="">
              </div>
              <div class="m-l-15">
                <h4 class="m-b-0"><%=p.getProdName()%></h4>
                <p class="text-muted m-b-0">ID: <%=p.getId()%></p>
              </div>
            </div>
          </div>
          <ul class="nav nav-tabs" >
            <li class="nav-item">
              <a class="nav-link active" href="#product-overview">Overview</a>
            </li>
          </ul>
        </div>
        <div class="container-fluid">
          <div class="tab-content m-t-15">
            <div class="tab-pane fade show active" id="product-overview" >
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Basic Info</h4>
                  <div class="table-responsive">
                    <table class="product-info-table m-t-20">
                      <tbody>
                      <tr>
                        <td>Price:</td>
                        <td class="text-dark font-weight-semibold"><%=df.format(p.getPrice())%> VNĐ</td>
                      </tr>
                      <tr>
                        <td>Unit in stock:</td>
                        <td class="text-dark font-weight-semibold"><%=p.getUnitInStock()%></td>
                      </tr>
                      <tr>
                        <td>Unit sold:</td>
                        <td class="text-dark font-weight-semibold"><%=p.getUnitSold()%></td>
                      </tr>
                      <tr>
                        <td>Category:</td>
                        <td>	<%=p.getCategory().getCatName()%></td>
                      </tr>
                      <tr>
                        <td>Supplier:</td>
                        <td>	<%=p.getSupplier().getSupName()%></td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-body">
                  <div class="card-title">Transaction list</div>
                  <div class="table-responsive">
                    <table class="table table-hover">
                      <%OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                        List<OrderDetail> list = orderDetailDAO.getOrderDetailById(id);
                      %>
                      <thead>
                      <tr>
                        <th scope="col">Order ID</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total money</th>
                      </tr>
                      </thead>
                      <tbody>
                      <%if (list != null){
                        for(OrderDetail o : list) {
                      %>
                      <tr>
                        <td><%=o.getOrder().getId()%></td>
                        <td><%=o.getQuantity()%></td>
                        <td><%=df.format(o.getQuantity() * p.getPrice())%> VNĐ</td>
                      </tr>
                      <%
                        }
                      }
                      %>

                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
      <!-- Content Wrapper END -->

      <!-- Footer START -->
      <footer class="footer">
        <div class="footer-content">
          <p class="m-b-0">Copyright © 2019 Theme_Nate. All rights reserved.</p>
          <span>
                            <a href="" class="text-gray m-r-15">Term &amp; Conditions</a>
                            <a href="" class="text-gray">Privacy &amp; Policy</a>
                        </span>
        </div>
      </footer>
      <!-- Footer END -->

    </div>
    <!-- Page Container END -->

    <!-- Search Start-->
    <!-- Quick View END -->
  </div>
</div>


<!-- Core Vendors JS -->
<script src="<%=request.getContextPath()%>/admin_assets/js/vendors.min.js"></script>

<!-- page js -->
<script src="<%=request.getContextPath()%>/admin_assets/vendors/chartjs/Chart.min.js"></script>
<script src="<%=request.getContextPath()%>/admin_assets/js/pages/dashboard-default.js"></script>

<!-- Core JS -->
<script src="<%=request.getContextPath()%>/admin_assets/js/app.min.js"></script>

</body>

</html>