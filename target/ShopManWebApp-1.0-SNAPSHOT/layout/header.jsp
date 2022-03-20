<%@ page import="com.example.ShopManWebApp.model.OrderDetail" %><%
    Customer c1 = (Customer) session.getAttribute("current-customer");
    List<OrderDetail> cart1 = (List<OrderDetail>) session.getAttribute("cart");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header_area position-relative">
    <div class="header-middle py-5">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-12">
                    <div class="header-middle-wrap">
                        <a href="<%=request.getContextPath()%>/views/product-list.jsp" class="header-logo">
                            <img src="<%=request.getContextPath()%>/assets/images/logo/dark.png" alt="Header Logo">
                        </a>
                        <div class="header-search-area d-none d-lg-block">
                            <form action="${pageContext.request.contextPath}/Search" class="header-searchbox" method="post">
                                <input class="input-field" type="text" placeholder="Search Products" name="search-key">
                                <button class="btn btn-outline-whisper btn-primary-hover" type="submit"><i
                                        class="pe-7s-search"></i></button>
                            </form>
                        </div>
                        <div class="header-right">
                            <ul>
                                <li class="dropdown d-none d-md-block">
                                    <button class="btn btn-link dropdown-toggle ht-btn p-0" type="button"
                                            id="settingButton" data-bs-toggle="dropdown" aria-expanded="false">
                                        <i class="pe-7s-users"></i>
                                    </button>
                                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="settingButton">
                                        <li><a class="dropdown-item" href="customer-account.jsp">Hello, <%=c1.getUsername()%></a></li>
                                        <li><a class="dropdown-item" href="customer-account.jsp">My account</a></li>
                                        <li><form action="${pageContext.request.contextPath}/CustomerLogout" method="post" id="logoutForm"><a class="dropdown-item" onclick="document.getElementById('logoutForm').submit();">Log out</a></form></li>
                                    </ul>
                                </li>
                                <li class="d-block d-lg-none">
                                    <a href="#searchBar" class="search-btn toolbar-btn">
                                        <i class="pe-7s-search"></i>
                                    </a>
                                </li>

                                <li class="minicart-wrap me-3 me-lg-0">
                                    <a href="<%=request.getContextPath()%>/views/cart.jsp" class="minicart-btn toolbar-btn">
                                        <i class="pe-7s-shopbag"></i>
                                        <%if (cart1 != null){
                                        %>
                                        <span class="quantity"><%=cart1.size()%></span>
                                        <%
                                            }
                                        %>
                                    </a>
                                </li>
                                <li class="mobile-menu_wrap d-block d-lg-none">
                                    <a href="#mobileMenu" class="mobile-menu_btn toolbar-btn pl-0">
                                        <i class="pe-7s-menu"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-header header-sticky" data-bg-color="#bac34e">
        <div class="container">
            <div class="main-header_nav position-relative">
                <div class="row align-items-center">
                    <div class="col-lg-12 d-none d-lg-block">
                        <div class="main-menu">
                            <nav class="main-nav">
                                <ul>
                                    <li>
                                        <a href="<%=request.getContextPath()%>/views/product-list.jsp">Shop</a>
                                    </li>
                                    <li>
                                        <a href="contact.html">About</a>
                                    </li>
                                    <li>
                                        <a href="contact.html">Contact</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>