package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.ProductStat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductStatDAO extends DAO {
    public ProductStatDAO() {
        super();
    }

    public List<ProductStat> getAllProductStat() {
        List<ProductStat> list = new ArrayList<>();
        String sql = "Select a.ID, a.Prod_name, (SELECT SUM(b.TotalQuantity) FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID AND c.Status = 'Done')) AS quantity, (SELECT SUM(b.TotalQuantity)*a.UnitPrice FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID AND c.Status = 'Done')) as revenue from products a ORDER BY revenue DESC";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductStat pt = new ProductStat();
                pt.setId(rs.getInt(1));
                pt.setProdName(rs.getString(2));
                pt.setQuantity(rs.getInt(3));
                pt.setRevenue(rs.getDouble(4));

                list.add(pt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<ProductStat> getProductStat(String startDate, String endDate) {
        List<ProductStat> list = new ArrayList<>();
        String sql = "Select a.ID, a.Prod_name, (SELECT SUM(b.TotalQuantity) FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID and c.Receive_date BETWEEN ? And ? AND c.Status = 'Done')) AS quantity, (SELECT SUM(b.TotalQuantity)*a.UnitPrice FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID and c.Receive_date BETWEEN ? And ? AND c.Status = 'Done')) as revenue from products a ORDER BY revenue DESC";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ps.setString(3, startDate);
            ps.setString(4, endDate);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductStat pt = new ProductStat();
                pt.setId(rs.getInt(1));
                pt.setProdName(rs.getString(2));
                pt.setQuantity(rs.getInt(3));
                pt.setRevenue(rs.getDouble(4));

                list.add(pt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // chi co ngay bat dau
    public List<ProductStat> getProductStat1(String startDate) {
        List<ProductStat> list = new ArrayList<>();
        String sql = "Select a.ID, a.Prod_name, (SELECT SUM(b.TotalQuantity) FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID and c.Receive_date >= ? AND c.Status = 'Done')) AS quantity, (SELECT SUM(b.TotalQuantity)*a.UnitPrice FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID and c.Receive_date >= ? AND c.Status = 'Done')) as revenue from products a ORDER BY revenue DESC";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, startDate);
            ps.setString(2, startDate);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductStat pt = new ProductStat();
                pt.setId(rs.getInt(1));
                pt.setProdName(rs.getString(2));
                pt.setQuantity(rs.getInt(3));
                pt.setRevenue(rs.getDouble(4));

                list.add(pt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //    Chi co ngay ket thuc
    public List<ProductStat> getProductStat2(String endDate) {
        List<ProductStat> list = new ArrayList<>();
        String sql = "Select a.ID, a.Prod_name, (SELECT SUM(b.TotalQuantity) FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID and c.Receive_date <= ? AND c.Status = 'Done')) AS quantity, (SELECT SUM(b.TotalQuantity)*a.UnitPrice FROM orderdetails b WHERE b.TotalQuantity > 0 AND  b.ProductID = a.ID AND b.OrderID IN (SELECT c.ID from orders c WHERE c.ID = b.OrderID and c.Receive_date <= ? AND c.Status = 'Done')) as revenue from products a ORDER BY revenue DESC";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, endDate);
            ps.setString(2, endDate);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductStat pt = new ProductStat();
                pt.setId(rs.getInt(1));
                pt.setProdName(rs.getString(2));
                pt.setQuantity(rs.getInt(3));
                pt.setRevenue(rs.getDouble(4));

                list.add(pt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
