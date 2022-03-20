package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Shipper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShipperDAO extends DAO{

    public ShipperDAO() {
        super();
    }

    public List<Shipper> getAllShipper(){
        List<Shipper> shippers = new ArrayList<>();
        String sql = "SELECT * FROM shippers";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Shipper shipper = new Shipper();
                shipper.setId(rs.getInt(1));
                shipper.setShipperName(rs.getString(2));
                shipper.setShipperCompany(rs.getString(3));
                shipper.setPhone(rs.getString(4));

                shippers.add(shipper);

            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return shippers;
    }
}
