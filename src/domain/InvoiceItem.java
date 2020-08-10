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

/**
 *
 * @author Katica
 */
public class InvoiceItem extends GeneralDomainObject{
    
    private Invoice invoice;
    private int itemNumber;
    private Product product;
    private double price;
    private int quantity;
    private double amount;

    public InvoiceItem() {
    }
    
    

    public InvoiceItem( Invoice invoice, int itemNumber, Product product, double price, int quantity, double amount) {
        
        this.invoice = invoice;
        this.itemNumber = itemNumber;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }

    

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

   
    @Override
    public String setAttributes() {
        return "(invoice_id,item_number,price,quantity,amount,product_id)";
    }

    @Override
    public String getClassName() {
        return "invoice_item";
    }

    @Override
    public String getWhereCondition() {
        return "";
    }

    @Override
    public String getAttributes() {
        return invoice.getId()+","+itemNumber+","+price+","+quantity+","+amount+","+product.getID();
    }

    @Override
    public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoice.setId(rs.getInt("invoice_id"));
        invoiceItem.setItemNumber(rs.getInt("invoice_number"));
        invoiceItem.setAmount(rs.getInt("amount"));
        invoiceItem.setQuantity(rs.getInt("quantity"));
        invoiceItem.setPrice(rs.getDouble("price"));
        
        Product product = new Product();
        int id = rs.getInt("product_id");
                product.setID(id);
                String name = rs.getString("name");
                product.setName(name);
                int quantity = rs.getInt("quantity");
                product.setQuantity(quantity);
                MeasurementUnit mu = MeasurementUnit.valueOf(rs.getString("measurement_unit"));
                product.setMeasurementUnit(mu);
                double priceWithVat = rs.getDouble("priceWithVat");
                product.setPriceWithVat(priceWithVat);
                double priceWithoutVat = rs.getDouble("priceWithoutVat");
                product.setPriceWithoutVAT(priceWithoutVat);
                
                invoiceItem.setProduct(product);
                return invoiceItem;
        
    }

    @Override
    public String getJoinCondition() {
        return "ii INNER JOIN product p on p.product_id = ii.product_id"; 
    }

    @Override
    public String getColumnNames() {
        return "(invoice_id,item_number,price,quantity,amount,product_id)";
    }

    @Override
    public void setPrimaryKey(ResultSet rs) throws SQLException {
        invoice.setId(rs.getInt(1));
    }

    
    
    
    
}
