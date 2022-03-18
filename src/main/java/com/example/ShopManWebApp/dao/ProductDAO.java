package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends DAO{
    static final Logger logger = Logger.getLogger(DAO.class.getName());
    CategoryDAO categoryDAO = new CategoryDAO();
    SupplierDAO supplierDAO = new SupplierDAO();
    public ProductDAO() {
        super();
    }

//    Lấy tất cả sản phẩm
    public List<Product> getAllProduct(){
        List<Product> products =  new ArrayList<Product>();
        String query = "SELECT * FROM products";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setProdName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setColor(rs.getString(4));
                product.setSize(rs.getString(5));
                product.setPicture(rs.getString(6));
                product.setStatus(rs.getString(7));
                product.setDiscount(rs.getDouble(8));
                product.setDescription(rs.getString(9));
                product.setCategory(categoryDAO.getCategoryById(rs.getInt(10)));
                product.setSupplier(supplierDAO.getSupplierById(rs.getInt(11)));

                products.add(product);
            }
        } catch (Exception e){
            logger.log(Level.SEVERE, "Fail getAllProduct", e);
        }
        return products;
    }
//  Tìm sản phẩm theo tên
    public List<Product> searchProduct(String keyword){
        List<Product> products =  new ArrayList<Product>();
        String query = "SELECT * FROM products WHERE Prod_name LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,"%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setProdName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setColor(rs.getString(4));
                product.setSize(rs.getString(5));
                product.setPicture(rs.getString(6));
                product.setStatus(rs.getString(7));
                product.setDiscount(rs.getDouble(8));
                product.setDescription(rs.getString(9));
                product.setCategory(categoryDAO.getCategoryById(rs.getInt(10)));
                product.setSupplier(supplierDAO.getSupplierById(rs.getInt(11)));

                products.add(product);
            }
        } catch (Exception e){
            logger.log(Level.SEVERE, "Fail getAllProduct", e);
        }
        return products;
    }

    public Product getProductById(int id){
        Product product =  new Product();
        String query = "SELECT * FROM products WHERE ID = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product.setId(rs.getInt(1));
                product.setProdName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setColor(rs.getString(4));
                product.setSize(rs.getString(5));
                product.setPicture(rs.getString(6));
                product.setStatus(rs.getString(7));
                product.setDiscount(rs.getDouble(8));
                product.setDescription(rs.getString(9));
                product.setCategory(categoryDAO.getCategoryById(rs.getInt(10)));
                product.setSupplier(supplierDAO.getSupplierById(rs.getInt(11)));
            }
        } catch (Exception e){
            logger.log(Level.SEVERE, "Fail getAllProduct", e);
        }
        return product;
    }
}
