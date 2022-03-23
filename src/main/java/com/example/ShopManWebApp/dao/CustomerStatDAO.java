package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.CustomerStat;
import com.example.ShopManWebApp.model.ProductStat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerStatDAO extends DAO{
    public CustomerStatDAO() {
        super();
    }

    public List<CustomerStat> getAllCustomerStat() {
        List<CustomerStat> list = new ArrayList<>();
        String sql = "select c.ID,\n" +
                "c.Cus_name,\n" +
                "(SELECT COUNT(*) FROM orders o WHERE o.CustomerID = c.ID AND o.Status ='Done') as order_time,\n" +
                "\n" +
                "(SELECT SUM(p.UnitPrice*od.TotalQuantity) FROM products p INNER JOIN orderdetails od ON p.ID = od.ProductID AND od.OrderID\n" +
                " IN(SELECT o.ID FROM orders o WHERE o.CustomerID = c.ID and o.Status ='Done')) as revenue\n" +
                "\n" +
                "from customers c ORDER BY revenue DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CustomerStat ct = new CustomerStat();
                ct.setId(rs.getInt(1));
                ct.setCusName(rs.getString(2));
                ct.setOrder_time(rs.getInt(3));
                ct.setRevenue(rs.getDouble(4));

                list.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<CustomerStat> getCustomerStat(String startDate, String endDate) {
        List<CustomerStat> list = new ArrayList<>();
        String sql = "select c.ID,\n" +
                "c.Cus_name,\n" +
                "(SELECT COUNT(*) FROM orders o WHERE o.CustomerID = c.ID AND o.Receive_date BETWEEN ? AND ? AND o.Status ='Done') as order_time,\n" +
                "\n" +
                "(SELECT SUM(p.UnitPrice*od.TotalQuantity) FROM products p INNER JOIN orderdetails od ON p.ID = od.ProductID AND od.OrderID\n" +
                " IN(SELECT o.ID FROM orders o WHERE o.CustomerID = c.ID AND o.Receive_date BETWEEN ? AND ? and o.Status ='Done')) as revenue\n" +
                "\n" +
                "from customers c ORDER BY revenue DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ps.setString(3, startDate);
            ps.setString(4, endDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CustomerStat ct = new CustomerStat();
                ct.setId(rs.getInt(1));
                ct.setCusName(rs.getString(2));
                ct.setOrder_time(rs.getInt(3));
                ct.setRevenue(rs.getDouble(4));

                list.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<CustomerStat> getCustomerStat1(String startDate) {
        List<CustomerStat> list = new ArrayList<>();
        String sql = "select c.ID,\n" +
                "c.Cus_name,\n" +
                "(SELECT COUNT(*) FROM orders o WHERE o.CustomerID = c.ID and o.Receive_date >= ? AND o.Status ='Done') as order_time,\n" +
                "\n" +
                "(SELECT SUM(p.UnitPrice*od.TotalQuantity) FROM products p INNER JOIN orderdetails od ON p.ID = od.ProductID AND od.OrderID\n" +
                " IN(SELECT o.ID FROM orders o WHERE o.CustomerID = c.ID AND o.Receive_date >= ? and o.Status ='Done')) as revenue\n" +
                "\n" +
                "from customers c ORDER BY revenue DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, startDate);
            ps.setString(2, startDate);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CustomerStat ct = new CustomerStat();
                ct.setId(rs.getInt(1));
                ct.setCusName(rs.getString(2));
                ct.setOrder_time(rs.getInt(3));
                ct.setRevenue(rs.getDouble(4));

                list.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<CustomerStat> getCustomerStat2(String endDate) {
        List<CustomerStat> list = new ArrayList<>();
        String sql = "select c.ID,\n" +
                "c.Cus_name,\n" +
                "(SELECT COUNT(*) FROM orders o WHERE o.CustomerID = c.ID and o.Receive_date <= ? AND o.Status ='Done') as order_time,\n" +
                "\n" +
                "(SELECT SUM(p.UnitPrice*od.TotalQuantity) FROM products p INNER JOIN orderdetails od ON p.ID = od.ProductID AND od.OrderID\n" +
                " IN(SELECT o.ID FROM orders o WHERE o.CustomerID = c.ID and o.Receive_date <= ? and o.Status ='Done')) as revenue\n" +
                "\n" +
                "from customers c ORDER BY revenue DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, endDate);
            ps.setString(2, endDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CustomerStat ct = new CustomerStat();
                ct.setId(rs.getInt(1));
                ct.setCusName(rs.getString(2));
                ct.setOrder_time(rs.getInt(3));
                ct.setRevenue(rs.getDouble(4));

                list.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
