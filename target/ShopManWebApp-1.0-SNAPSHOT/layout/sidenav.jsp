<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/20/2022
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="side-nav">
    <div class="side-nav-inner">
        <ul class="side-nav-menu scrollable">
            <li class="nav-item dropdown open">
                <a class="dropdown-toggle" href="javascript:void(0);">
                                <span class="icon-holder">
                                    <i class="anticon anticon-dashboard"></i>
                                </span>
                    <span class="title">Dashboard</span>
                </a>
            </li>
            <li class="nav-item dropdown open">
                <a class="dropdown-toggle" href="javascript:void(0);">
                                <span class="icon-holder">
                                    <i class="anticon anticon-line-chart"></i>
                                </span>
                    <span class="title">Statistics</span>
                    <span class="arrow">
                                    <i class="arrow-icon"></i>
                                </span>
                </a>
                <ul class="dropdown-menu">
                    <li class="">
                        <a href="<%=request.getContextPath()%>/views/admin/customer-statistic.jsp">Customer Statistics</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/views/admin/product-statistic.jsp">Product Statistics</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>