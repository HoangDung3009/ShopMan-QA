package com.example.ShopManWebApp.dao;


import java.sql.*;


public class DAO {
    public static Connection con;

    public static String dbUrl =
            "jdbc:mysql://localhost:3306/shop";
    public static String dbClass = "com.mysql.cj.jdbc.Driver";
    public DAO(){
        if(con == null){
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
