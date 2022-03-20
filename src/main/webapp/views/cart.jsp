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
    <title>Cart</title>
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
        List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
        DecimalFormat df = new DecimalFormat("#,###.##");
    %>
    <!-- Begin Main Header Area -->
    <%@include file="../layout/header.jsp" %>
    <!-- Main Header Area End Here -->

    <%%>
    <!-- Begin Main Content Area -->
    <div class="cart-area section-space-y-axis-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="javascript:void(0)">
                        <div class="table-content table-responsive">
                            <table class="table">
                                <%
                                    double total = 0;

                                %>
                                <%if (cart != null) {

                                %>
                                <thead>
                                <tr>
                                    <th class="product_remove">remove</th>
                                    <th class="product-thumbnail">images</th>
                                    <th class="cart-product-name">Product</th>
                                    <th class="product-price">Unit Price</th>
                                    <th class="product-quantity">Quantity</th>
                                    <th class="product-subtotal">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <%for (OrderDetail o : cart){

                                        o.setTotalPrice(o.getProduct().getPrice() * o.getQuantity());
                                    %>
                                    <td class="product_remove">
                                        <a href="${pageContext.request.contextPath}/Cart?command=removeFromCart&product_id=<%=o.getProduct().getId()%>">
                                            <i class="pe-7s-close" title="Remove"></i>
                                        </a>
                                    </td>
                                    <td class="product-thumbnail">
                                        <a href="javascript:void(0)">
                                            <img src="<%=request.getContextPath()%>/assets/images/product/<%=o.getProduct().getPicture()%>" style="width: 112px; height: 124px;" alt="Cart Thumbnail">
                                        </a>
                                    </td>
                                    <td class="product-name"><a href="javascript:void(0)"><%=o.getProduct().getProdName()%></a></td>
                                    <td class="product-price"><span class="amount"><%=df.format(o.getProduct().getPrice())%>VNĐ</span></td>
                                    <td class="quantity">
                                        <div class="">
                                            <a class="btn btn-sm" href="${pageContext.request.contextPath}/Cart?command=deleteFromCart&product_id=<%=o.getProduct().getId()%>"> - </a>
                                            <%=o.getQuantity()%>
                                            <a class="btn btn-sm" href="${pageContext.request.contextPath}/Cart?command=addCart&product_id=<%=o.getProduct().getId()%>"> + </a>
                                        </div>
                                    </td>
                                    <td class="product-subtotal"><span class="amount"><%=df.format(o.getTotalPrice())%> VNĐ</span></td>
                                </tr>
                                <%
                                        total += o.getTotalPrice();
                                    }
                                %>
                                </tbody>
                            </table>
                            <%
                                }
                            %>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <div class="coupon-all">
                                    <div class="coupon2">
                                        <% if (cart.size() > 0) {

                                        %>
                                        <form action="${pageContext.request.contextPath}/Cart" method="post">
                                            <input type="hidden" name="command" value="removeAll">
                                            <input class="button" name="remove_cart" value="Remove All" type="submit">
                                        </form>
                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--Total Money --%>
                        <div class="row">
                            <div class="col-md-5 ml-auto">
                                <div class="cart-page-total">
                                    <h2>Cart totals</h2>
                                    <ul>
                                        <li>Total <span><%=df.format(total)%> VNĐ</span></li>
                                    </ul>
                                    <%if (cart.size() > 0) { %>
                                    <a href="checkout.jsp">Proceed to checkout</a>
                                    <%
                                    }
                                    %>

                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
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
