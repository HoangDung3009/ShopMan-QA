package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO extends DAO{
    static final Logger logger = Logger.getLogger(DAO.class.getName());

    public CustomerDAO() {
        super();
    }

    public Customer checkLogin(String username, String password){
        Customer c = null;
        String query = "SELECT * FROM customers WHERE Username = ? AND Password = ?" ;
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Customer();
                c.setId(rs.getInt(1));
                c.setCusName(rs.getString(2));
                c.setPhone(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setUsername(rs.getString(5));
                c.setPassword(rs.getString(6));
                c.setCreditCard(rs.getString(7));
                c.setCreditCardType(rs.getString(8));
                c.setCardExpMonth(rs.getString(9));
                c.setCardExpYear(rs.getString(10));
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Fail checkLogin", e);
        }
        return c;
    }

    public Customer getCustomerById(int id){
        Customer c = null;
        String query = "SELECT * FROM customers WHERE ID = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c = new Customer();
                c.setId(rs.getInt(1));
                c.setCusName(rs.getString(2));
                c.setPhone(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setUsername(rs.getString(5));
                c.setPassword(rs.getString(6));
                c.setCreditCard(rs.getString(7));
                c.setCreditCardType(rs.getString(8));
                c.setCardExpMonth(rs.getString(9));
                c.setCardExpYear(rs.getString(10));
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Fail getCustomer", e);
        }
        return c;
    }
}
