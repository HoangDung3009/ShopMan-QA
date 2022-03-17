package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffDAO extends DAO{
    static final Logger logger = Logger.getLogger(DAO.class.getName());

    public StaffDAO() {
    }

    public Staff checkLogin(String username, String password){
        Staff staff = new Staff();
        String query = "select * from staffs where username = ? and password = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                staff.setId(rs.getInt("ID"));
                staff.setPhone(rs.getString("Phone"));
                staff.setEmail(rs.getString("Email"));
                staff.setUsername(rs.getString("Username"));
                staff.setPassword(rs.getString("Password"));

            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Fail checkLogin", e);
        }
        return staff;
    }
}
