<%--
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
  <title>Admin Dashboard</title>

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


      <!-- Content Wrapper START -->
      <div class="main-content">
        <div class="row">
          <div class="col-md-6 col-lg-3">
            <div class="card">
              <div class="card-body">
                <div class="media align-items-center">
                  <div class="avatar avatar-icon avatar-lg avatar-blue">
                    <i class="anticon anticon-dollar"></i>
                  </div>
                  <div class="m-l-15">
                    <h2 class="m-b-0">$23,523</h2>
                    <p class="m-b-0 text-muted">Profit</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="card">
              <div class="card-body">
                <div class="media align-items-center">
                  <div class="avatar avatar-icon avatar-lg avatar-cyan">
                    <i class="anticon anticon-line-chart"></i>
                  </div>
                  <div class="m-l-15">
                    <h2 class="m-b-0">+ 17.21%</h2>
                    <p class="m-b-0 text-muted">Growth</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="card">
              <div class="card-body">
                <div class="media align-items-center">
                  <div class="avatar avatar-icon avatar-lg avatar-gold">
                    <i class="anticon anticon-profile"></i>
                  </div>
                  <div class="m-l-15">
                    <h2 class="m-b-0">3,685</h2>
                    <p class="m-b-0 text-muted">Orders</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="card">
              <div class="card-body">
                <div class="media align-items-center">
                  <div class="avatar avatar-icon avatar-lg avatar-purple">
                    <i class="anticon anticon-user"></i>
                  </div>
                  <div class="m-l-15">
                    <h2 class="m-b-0">1,832</h2>
                    <p class="m-b-0 text-muted">Customers</p>
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