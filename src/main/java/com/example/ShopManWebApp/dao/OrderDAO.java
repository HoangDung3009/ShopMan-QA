package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrderDAO extends DAO{
    public OrderDAO() {
        super();
    }

    public List<Order> getOrderByCustomer(int id){
        List<Order> list =  new ArrayList<>();
        String query = "SELECT * FROM orders WHERE CustomerID = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Order o = new Order();
                o.setId(rs.getInt(1));
                o.setOrderDate(rs.getString(2));
                Shipper shipper = new Shipper(); shipper.setId(rs.getInt(3));
                Customer customer = new Customer(); customer.setId(rs.getInt(4));
                Payment payment = new Payment(); payment.setId(rs.getInt(5));
                ShippingAddress shippingAddress = new ShippingAddress(); shippingAddress.setId(rs.getInt(6));
                Staff staff = new Staff(); staff.setId(rs.getInt(7));
                o.setShipper(shipper);
                o.setCustomer(customer);
                o.setPayment(payment);
                o.setShippingAddress(shippingAddress);
                o.setStaff(staff);
                o.setReceive_date(rs.getString(8));
                o.setStatus(rs.getString(9));

                list.add(o);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void addOrder(Order order){
        String sql = "INSERT INTO orders (Oreder_date, ShipperID, CustomerID, PaymentID, ShippingAddressID, Status) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getOrderDate());
            ps.setInt(2, order.getShipper().getId());
            ps.setInt(3, order.getCustomer().getId());
            ps.setInt(4, order.getPayment().getId());
            ps.setInt(5, order.getShippingAddress().getId());
            ps.setString(6, order.getStatus());


            ps.executeUpdate();

            //get id of the new inserted order
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
