package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Order;
import com.example.ShopManWebApp.model.OrderDetail;
import com.example.ShopManWebApp.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO extends DAO{
    public OrderDetailDAO() {
        super();
    }

    public List<OrderDetail> getOrderDetailByOrder(int id){
        List<OrderDetail> o = new ArrayList<>();

        String sql = "SELECT * FROM orderdetails WHERE OrderID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(rs.getInt(1));
                orderDetail.setTotalPrice(rs.getDouble(2));
                orderDetail.setQuantity(rs.getInt(3));
                orderDetail.setShip_date(rs.getString(4));
                Order od = new Order(); od.setId(rs.getInt(5));
                Product p = new Product(); p.setId(rs.getInt(6));
                orderDetail.setOrder(od);
                orderDetail.setProduct(p);

                o.add(orderDetail);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return o;
    }


    public void addOrderDetail(OrderDetail orderDetail){
        String sql = "INSERT INTO orderdetails (TotalMoney, TotalQuantity, OrderID, ProductID) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, orderDetail.getTotalPrice());
            ps.setInt(2, orderDetail.getQuantity());
            ps.setInt(3, orderDetail.getOrder().getId());
            ps.setInt(4, orderDetail.getProduct().getId());

            ps.executeUpdate();

            //get id of the new inserted orderDetail
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                orderDetail.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<OrderDetail> getOrderDetailById(int id){
        List<OrderDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM orderdetails WHERE ProductID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                OrderDetail o = new OrderDetail();
                o.setId(rs.getInt(1));
                o.setTotalPrice(rs.getDouble(2));
                o.setQuantity(rs.getInt(3));
                o.setShip_date(rs.getString(4));
                Order od = new Order(); od.setId(rs.getInt(5));
                Product p = new Product(); p.setId(rs.getInt(6));
                o.setOrder(od);
                o.setProduct(p);

                list.add(o);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
