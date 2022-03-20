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
    <%@ page import="com.example.ShopManWebApp.dao.ProductDAO" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.text.DecimalFormat" %>
    <%@ page import="com.example.ShopManWebApp.dao.ShipperDAO" %>
    <%@ page import="com.example.ShopManWebApp.model.*" %>
    <%@ page import="com.example.ShopManWebApp.dao.PaymentDAO" %>
    <%
        Customer c = (Customer) session.getAttribute("current-customer");
        List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
        DecimalFormat df = new DecimalFormat("#,###.##");
    %>
    <!-- Begin Main Header Area -->
    <%@include file="../layout/header.jsp" %>
    <!-- Main Header Area End Here -->

    <!-- Begin Main Content Area -->
    <main class="main-content">
        <div class="checkout-area section-space-y-axis-100">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-12">
                        <form id="checkoutForm" action="${pageContext.request.contextPath}/CheckOut" method="post">
                            <div class="checkbox-form">
                                <h3>Billing Details</h3>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="checkout-form-list">
                                            <label>City / Province <span class="required">*</span></label>
                                            <input placeholder="" type="text" name="city" required>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="checkout-form-list">
                                            <label>District <span class="required">*</span></label>
                                            <input type="text" name="district" required>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="checkout-form-list">
                                            <label>Road <span class="required">*</span></label>
                                            <input placeholder="" type="text" name="road" required>
                                        </div>
                                    </div>
                                    <%ShipperDAO shipperDAO = new ShipperDAO();
                                        List<Shipper> shippers = shipperDAO.getAllShipper();
                                    %>
                                    <div class="col-md-12">
                                        <div class="country-select clearfix">
                                            <label>Shipper <span class="required">*</span></label>
                                            <select name="shipper" class="myniceselect nice-select wide">
                                                <% if (shippers != null) {
                                                    for (Shipper s : shippers){
                                                %>
                                                <option value="<%=s.getId()%>"><%=s.getShipperName()%></option>
                                                <%
                                                    }
                                                }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <%
                                        PaymentDAO paymentDAO = new PaymentDAO();
                                        List<Payment> payments = paymentDAO.getAllPayment();
                                    %>
                                    <div class="col-md-12">
                                        <div class="country-select clearfix">
                                            <label>Payment <span class="required">*</span></label>
                                            <select name="payment" class="myniceselect nice-select wide">
                                                <% if (payments != null) {
                                                    for (Payment p : payments){
                                                %>
                                                <option value="<%=p.getId()%>"><%=p.getMethod()%></option>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-6 col-12">
                        <div class="your-order">
                            <h3>Your order</h3>
                            <div class="your-order-table table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th class="cart-product-name">Product</th>
                                        <th class="cart-product-total">Total</th>
                                    </tr>
                                    </thead>
                                    <% double total = 0;%>
                                    <%if (cart != null) {%>

                                    <tbody>
                                    <% for (OrderDetail o : cart) {%>
                                    <tr class="cart_item">
                                        <td class="cart-product-name"> <%=o.getProduct().getProdName()%><strong class="product-quantity">
                                            × <%=o.getQuantity()%></strong></td>
                                        <td class="cart-product-total"><span class="amount"><%=df.format(o.getTotalPrice())%> VNĐ</span></td>
                                    </tr>
                                    <%
                                            total += o.getTotalPrice();
                                        }
                                    %>
                                    </tbody>

                                    <tfoot>
                                    <tr class="order-total">
                                        <th>Order Total</th>
                                        <td><strong><span class="amount"><%=df.format(total)%> VNĐ</span></strong></td>
                                    </tr>
                                    </tfoot>
                                    <%
                                        }
                                    %>
                                </table>

                                <div class="order-button-payment">
                                    <input value="Place order" type="submit" form="checkoutForm" onclick="alert('Đặt hàng thành công !!')">
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
<script>

</script>
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
