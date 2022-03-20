package com.example.ShopManWebApp.dao;

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


}
