package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO extends DAO{
    static final Logger logger = Logger.getLogger(DAO.class.getName());

    public CustomerDAO() {
    }

    public Customer checkLogin(String username, String password){
        Customer c = new Customer();
        String query = "select * from customers where username = ? and password = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setCusName(rs.getString("Cus_name"));
                c.setPhone(rs.getString("Phone"));
                c.setEmail(rs.getString("Email"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setCreditCard(rs.getString("CreditCard"));
                c.setCreditCardType(rs.getString("CreditCardTypeID"));
                c.setCardExpMonth(rs.getString("CardExpMon"));
                c.setCardExpYear(rs.getString("CardExpYr"));
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Fail checkLogin", e);
        }
        return c;
    }
}
