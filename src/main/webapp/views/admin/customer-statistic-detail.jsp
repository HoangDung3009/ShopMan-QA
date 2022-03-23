<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.ShopManWebApp.dao.ProductDAO" %>
<%@ page import="com.example.ShopManWebApp.dao.OrderDetailDAO" %>
<%@ page import="com.example.ShopManWebApp.dao.CustomerDAO" %>
<%@ page import="com.example.ShopManWebApp.model.*" %>
<%@ page import="com.example.ShopManWebApp.dao.OrderDAO" %><%--
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
  <title>Customer Detail</title>

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
  <%
    CustomerDAO customerDAO = new CustomerDAO();
    int id = Integer.parseInt(request.getParameter("cus_id"));
    Customer c = customerDAO.getCustomerById(id);
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
<%--                <img src="<%=request.getContextPath()%>/assets/images/product/<%=c.getPicture()%>" alt="">--%>
              </div>
              <div class="m-l-15">
                <h4 class="m-b-0"><%=c.getCusName()%></h4>
                <p class="text-muted m-b-0">ID: <%=c.getId()%></p>
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
                        <td>Name :</td>
                        <td class="text-dark font-weight-semibold"><%=c.getCusName()%></td>
                      </tr>
                      <tr>
                        <td>Phone :</td>
                        <td class="text-dark font-weight-semibold"><%=c.getPhone()%></td>
                      </tr>
                      <tr>
                        <td>Email :</td>
                        <td class="text-dark font-weight-semibold"><%=c.getEmail()%></td>
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
                      <%
                        OrderDAO orderDAO = new OrderDAO();
                        List<Order> list = orderDAO.getOrderByCustomer(id);
                      %>
                      <thead>
                      <tr>
                        <th scope="col">Order ID</th>
                        <th scope="col">Order date</th>
                        <th scope="col">Receive date</th>
                        <th scope="col">Status</th>
                        <th></th>
                      </tr>
                      </thead>
                      <tbody>
                      <%if (list != null){
                        for(Order o : list) {
                      %>
                        <tr>
                          <td><%=o.getId()%></td>
                          <td><%=o.getOrderDate()%></td>
                          <%if (o.getReceive_date() == null) {
                          %>
                          <td></td>
                          <%
                          } else {
                          %>
                          <td><%=o.getReceive_date()%></td>
                          <%
                            }
                          %>
                          <td><%=o.getStatus()%></td>
                          <td class="text-right">
                            <a href=""  class="btn btn-icon btn-hover btn-sm btn-rounded pull-right">
                              <i class="anticon anticon-eye"></i>
                            </a>
                          </td>
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

    <div class="modal fade" id="exampleModalCenter">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalCenterTitle">Modal title</h5>
            <button type="button" class="close" data-dismiss="modal">
              <i class="anticon anticon-close"></i>
            </button>
          </div>
          <div class="modal-body" id="modal-order-detail">

          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
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


</script>
</body>

</html>