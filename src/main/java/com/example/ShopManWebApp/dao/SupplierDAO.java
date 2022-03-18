package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplierDAO extends DAO{
    static final Logger logger = Logger.getLogger(DAO.class.getName());
    public SupplierDAO() {
        super();
    }

    public Supplier getSupplierById(int id){

        Supplier supplier = new Supplier();
        String query = "SELECT * FROM suppliers WHERE ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                supplier.setId(rs.getInt(1));
                supplier.setSupName(rs.getString(2));
                supplier.setAddress(rs.getString(3));
                supplier.setCity(rs.getString(4));
                supplier.setPhone(rs.getString(5));
                supplier.setEmail(rs.getString(6));
            }
        } catch (Exception e){
            logger.log(Level.SEVERE, "Fail getSupplierById", e);
        }
        return supplier;
    }
}
