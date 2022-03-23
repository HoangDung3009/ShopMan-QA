<%@ page import="com.example.ShopManWebApp.model.ProductStat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %><%--
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
  <title>Product Statistic</title>

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
        <div class="page-header">
          <h2 class="header-title">Statistics</h2>
          <div class="header-sub-title">
            <nav class="breadcrumb breadcrumb-dash">
              <a href="#" class="breadcrumb-item"><i class="anticon anticon-home m-r-5"></i>Statistics</a>
              <a class="breadcrumb-item" href="#">Product Statistics</a>
            </nav>
          </div>
        </div>
        <div class="card">
          <div class="card-body">
            <div class="row m-b-30">
              <form action="${pageContext.request.contextPath}/ProductStat" method="post">
                <div class="col-lg-8">
                  <div class="d-md-flex">
                    <div class="m-b-10 m-r-20">
                      <label>From:</label>
                      <input type="date" class="form-control" name="start-date" placeholder="Start date">
                    </div>
                    <div class="m-b-10">
                      <label>To:</label>
                      <input type="date" class="form-control" name="end-date" placeholder="End date">
                    </div>
                    <button class="btn btn-primary ml-5" type="submit">
                      <i class="anticon anticon-line-chart"></i>
                      <span>Stat</span>
                    </button>
                  </div>
                </div>
              </form>
            </div>
            <%List<ProductStat> listStat = (List<ProductStat>) session.getAttribute("product-stat");
              DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            %>
            <div class="table-responsive">
              <table class="table table-hover e-commerce-table">
                <thead>
                <tr>
                  <th>#</th>
                  <th>ID</th>
                  <th>Product</th>
                  <th>Revenue</th>
                  <th>Quantity Sold</th>
                  <th></th>
                </tr>
                </thead>
                <tbody>
                <%if (listStat != null) {
                  int index = 1;
                  for(ProductStat i : listStat){

                    %>

                <tr>
                  <td>
                    <%=index%>
                  </td>
                  <td>
                    <%=i.getId()%>
                  </td>
                  <td>
                    <div class="d-flex align-items-center">
                      <h6 class="m-b-0 m-l-10"><%=i.getProdName()%></h6>
                    </div>
                  </td>
                  <td><%=decimalFormat.format(i.getRevenue())%></td>
                  <td><%=i.getQuantity()%></td>
                  <td class="text-right">
                    <a href="product-statistic-detail.jsp?prod_id=<%=i.getId()%>" class="btn btn-icon btn-hover btn-sm btn-rounded pull-right">
                      <i class="anticon anticon-eye"></i>
                    </a>
                  </td>
                </tr>
                <%
                      index++;
                    }
                  }
                %>
                </tbody>
              </table>
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