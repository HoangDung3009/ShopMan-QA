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
        <div class="single-product-area section-space-top-100">
            <div class="container">
                <div class="row">
                    <%
                        String product_id = "";
                        if(request.getParameter("product_id") != null){
                            product_id = request.getParameter("product_id");
                        }
                        int id = Integer.parseInt(product_id);

                        ProductDAO productDAO = new ProductDAO();
                        DecimalFormat df = new DecimalFormat("#,###.##");

                        Product product = productDAO.getProductById(id);
                    %>
                    <div class="col-lg-6">
                        <div class="single-product-img h-100">
                            <div class="swiper-container single-product-slider">
                                <div class="swiper-wrapper">
                                    <div class="swiper-slide">
                                        <a href="<%=request.getContextPath()%>/assets/images/product/large-size/2-1-555x645.jpg" class="single-img gallery-popup">
                                            <img class="img-full" style="width: 555px; height: 645px;" src="<%=request.getContextPath()%>/assets/images/product/<%=product.getPicture()%>" alt="Product Image">
                                        </a>
                                    </div>
                                </div>
                                <!-- Add Pagination -->
                                <div class="swiper-pagination"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="product-thumb-with-content row">
                            <div class="col-12 order-lg-1 order-2 pt-10 pt-lg-0">
                                <div class="single-product-content">
                                    <h2 class="title"><%=product.getProdName()%></h2>
                                    <div class="price-box pb-1">
                                        <span class="new-price text-danger"><%=df.format(product.getPrice())%> VNĐ</span>
                                    </div>
                                    <div class="rating-box-wrap pb-7">
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
                                    <p class="short-desc mb-6">{{ product_details.product_description }}</p>
                                    <form action="${pageContext.request.contextPath}/Cart" method="post">
                                        <ul class="quantity-with-btn pb-7">
                                            <li class="quantity">
                                                <div class="cart-plus-minus">
                                                    <input class="cart-plus-minus-box" min="1" value="1" type="number" name="quantity">
                                                    <input type="hidden" value="<%=id%>" name="product_id">
                                                    <input type="hidden" name="command" value="setCart">
                                                </div>
                                            </li>
                                            <li class="add-to-cart">
                                                <input class="btn btn-custom-size lg-size btn-primary btn-secondary-hover rounded-0" type="submit" value="Add cart"/>
                                            </li>
                                        </ul>
                                    </form>

                                    <div class="product-category text-matterhorn pb-2">
                                        <span class="title">Categories :</span>
                                        <ul>
                                            <li>
                                                <a href="javascript:void(0)"><%=product.getCategory().getCatName()%></a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="social-link align-items-center pb-lg-8">
                                        <span class="title pe-3">Share:</span>
                                        <ul>
                                            <li>
                                                <a href="javascript:void(0)">
                                                    <i class="fa fa-pinterest-p"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void(0)">
                                                    <i class="fa fa-twitter"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void(0)">
                                                    <i class="fa fa-tumblr"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void(0)">
                                                    <i class="fa fa-dribbble"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
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
