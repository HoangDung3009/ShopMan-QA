package com.example.ShopManWebApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    public static Connection con;
    static final Logger logger = Logger.getLogger(DAO.class.getName());

    public DAO() {
        boolean checkDbConnect = dbConnection();
        if(!checkDbConnect){
            logger.log(Level.SEVERE, "Fail connect DB");
            return;
        }
    }

    private boolean dbConnection(){
        String dbUrl = "jdbc:mysql://localhost:3306/shop?autoReconnect=true&useSSL=false";
        String dbClass = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = (Connection) DriverManager.getConnection(dbUrl, "root", "");
            logger.log(Level.INFO, "Db Connected");
        } catch (Exception e){
            logger.log(Level.SEVERE, "Error connect DB", e);
        }
        return true;
    }
}
