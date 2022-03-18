package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO extends DAO{
    static final Logger logger = Logger.getLogger(DAO.class.getName());
    public CategoryDAO() {
        super();
    }

    public Category getCategoryById(int id){
        Category category = new Category();
        String query = "SELECT * FROM categories WHERE ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                category.setId(rs.getInt(1));
                category.setCatName(rs.getString(2));
                category.setCatDescription(rs.getString(3));
            }
        } catch (Exception e){
            logger.log(Level.SEVERE, "Fail getCategoryById", e);
        }
        return category;
    }
}
