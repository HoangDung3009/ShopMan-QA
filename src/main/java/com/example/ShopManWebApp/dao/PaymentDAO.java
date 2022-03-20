package com.example.ShopManWebApp.dao;

import com.example.ShopManWebApp.model.Payment;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO extends DAO{
    public PaymentDAO() {
        super();
    }

    public List<Payment> getAllPayment(){
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Payment payment = new Payment();
                payment.setId(rs.getInt(1));
                payment.setMethod(rs.getString(2));
                payment.setAllowed(rs.getString(3));

                payments.add(payment);

            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return payments;
    }
}
