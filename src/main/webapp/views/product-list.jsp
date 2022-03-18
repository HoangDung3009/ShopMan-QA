<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/17/2022
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Product List</title>
    <meta name="robots" content="noindex, follow"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/assets/images/favicon.ico"/>

    <!-- CSS
    ============================================ -->

    <!-- Vendor CSS (Contain Bootstrap, Icon Fonts) -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/vendor/font-awesome.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/vendor/Pe-icon-7-stroke.css"/>

    <!-- Plugin CSS (Global Plugins Files) -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/plugins/animate.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/plugins/jquery-ui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/plugins/swiper-bundle.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/plugins/nice-select.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/plugins/magnific-popup.min.css"/>

    <!-- Style CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">

</head>

<body>

<div class="main-wrapper">
    <%@page import="com.example.ShopManWebApp.model.Customer" %>
    <%@page import="com.example.ShopManWebApp.model.OrderDetail" %>
    <%@ page import="com.example.ShopManWebApp.dao.ProductDAO" %>
    <%@ page import="com.example.ShopManWebApp.model.Product" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.text.DecimalFormat" %>
    <%
        Customer c = (Customer) session.getAttribute("current-customer");

    %>
    <!-- Begin Main Header Area -->
    <%@include file="../layout/header.jsp" %>
    <!-- Main Header Area End Here -->

    <!-- Begin Main Content Area -->
    <main class="main-content">
        <div class="shop-area section-space-y-axis-100">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="tab-content text-charcoal pt-8">
                            <div class="tab-pane fade show active" id="grid-view" role="tabpanel"
                                 aria-labelledby="grid-view-tab">
                                <div class="product-grid-view row">
                                    <%
                                        DecimalFormat df = new DecimalFormat("#,###.##");
                                        ProductDAO productDAO = new ProductDAO();
                                        List<Product> productList;
                                        productList = productDAO.getAllProduct();
                                    %>
                                    <%--Liệt kê sản phẩm--%>
                                    <%
                                        for (Product product : productList) {
                                    %>
                                    <div class="col-lg-3 col-sm-6">
                                        <div class="product-item">
                                            <div class="product-img img-zoom-effect">
                                                <a href="product-detail.jsp?product_id=<%=product.getId()%>">
                                                    <img class="img-full"
                                                         style="width: 270px; height: 300px;"
                                                         src="<%=request.getContextPath()%>/assets/images/product/<%=product.getPicture()%>"
                                                         alt="Product Images">
                                                </a>
                                                <div class="product-add-action">
                                                    <ul>
                                                        <li>
                                                            <a href="cart.html">
                                                                <i class="pe-7s-cart"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="product-content">
                                                <a class="product-name" href="single-product.html"><%=product.getProdName()%></a>
                                                <div class="price-box pb-1">
                                                    <span class="new-price"><%=df.format(product.getPrice())%> VNĐ</span>
                                                </div>
                                                <div class="rating-box">
                                                    <ul>
                                                        <li><i class="pe-7s-star"></i></li>
                                                        <li><i class="pe-7s-star"></i></li>
                                                        <li><i class="pe-7s-star"></i></li>
                                                        <li><i class="pe-7s-star"></i></li>
                                                        <li><i class="pe-7s-star"></i></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Main Content Area End Here -->

    <!-- Begin Footer Area -->
    <%--    <%@include file="../layout/footer.jsp"%>--%>
    <%@include file="../layout/footer.jsp" %>
    <!-- Footer Area End Here -->

    <!-- Begin Scroll To Top -->
    <a class="scroll-to-top" href="">
        <i class="fa fa-chevron-up"></i>
    </a>
    <!-- Scroll To Top End Here -->

</div>

<!-- Global Vendor, plugins JS -->

<!-- JS Files
============================================ -->
<!-- Global Vendor, plugins JS -->

<!-- Vendor JS -->
<script src="<%=request.getContextPath()%>/assets/js/vendor/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/vendor/jquery-3.5.1.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/vendor/jquery-migrate-3.3.0.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/vendor/modernizr-3.11.2.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/vendor/jquery.waypoints.js"></script>

<!--Plugins JS-->
<script src="<%=request.getContextPath()%>/assets/js/plugins/wow.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/plugins/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/plugins/swiper-bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/plugins/jquery.nice-select.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/plugins/parallax.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/plugins/jquery.magnific-popup.min.js"></script>

<!--Main JS (Common Activation Codes)-->
<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>

</body>

</html>
