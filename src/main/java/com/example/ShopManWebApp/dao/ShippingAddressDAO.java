package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Customer;
import com.example.ShopManWebApp.model.OrderDetail;
import com.example.ShopManWebApp.model.ShippingAddress;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShippingAddressDAO extends DAO{
    public ShippingAddressDAO() {
        super();
    }

    public void addShipAddress(ShippingAddress shippingAddress){
        String sql = "INSERT INTO shippingaddress (Road, State, City, CustomerID) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);;
            ps.setString(1, shippingAddress.getRoad());
            ps.setString(2, shippingAddress.getDistrict());
            ps.setString(3, shippingAddress.getCity());
            ps.setInt(4, shippingAddress.getCustomer().getId());


            ps.executeUpdate();

            //get id of the new inserted shippingAddress
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                shippingAddress.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public ShippingAddress checkAddress(ShippingAddress shippingAddress){
        ShippingAddress address = null;
        String sql = "SELECT * FROM shippingaddress where CustomerID = ? AND City = ? AND State = ? AND Road = ?";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, shippingAddress.getCustomer().getId());
            ps.setString(2, shippingAddress.getCity());
            ps.setString(3, shippingAddress.getDistrict());
            ps.setString(4, shippingAddress.getRoad());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                address = new ShippingAddress();
                address.setId(rs.getInt(1));
                address.setRoad(rs.getString(2));
                address.setDistrict(rs.getString(3));
                address.setCity(rs.getString(4));
                Customer c = new Customer(); c.setId(rs.getInt(5));
                address.setCustomer(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return address;
    }


}
