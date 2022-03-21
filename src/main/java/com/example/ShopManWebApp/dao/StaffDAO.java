package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffDAO extends DAO{
    static final Logger logger = Logger.getLogger(DAO.class.getName());

    public StaffDAO() {
        super();
    }

    public Staff checkLogin(String username, String password){
        Staff staff = null;
        String query = "select * from staffs where Username = ? and Password = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                staff = new Staff();
                staff.setId(rs.getInt(1));
                staff.setUsername(rs.getString(2));
                staff.setUsername(rs.getString(3));
                staff.setPhone(rs.getString(4));
                staff.setEmail(rs.getString(5));
                staff.setRole(rs.getString(6));
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Fail checkLogin", e);
        }
        return staff;
    }
}
