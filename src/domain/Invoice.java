/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Katica
 */
public class Invoice extends GeneralDomainObject {

    private int id;
    private User createdUser;
    private double amount;
    private List<InvoiceItem> items;

    public Invoice() {
        items = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

 
    @Override
    public String setAttributes() {
        return "amount";
    }

    @Override
    public String getClassName() {
        return "invoice";
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAttributes() {
       return String.valueOf(this.getAmount());
    }

    @Override
    public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(rs.getInt("invoice_id"));
        invoice.setAmount(rs.getDouble("amount"));
        return invoice;
    }

    @Override
    public void setPrimaryKey(ResultSet rs) throws SQLException {
        id = rs.getInt(1);
    }

    @Override
    public String getColumnNames() {
        return "(amount)";
    }
    

    

}
