/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Katica
 */
public class OrderItem extends GeneralDomainObject {

    private Order order;
    private int numberOrderItem;
    private int quantityOrder;
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Order order,int numberOrderItem, int quantityOrder, Product product) {
        this.order = order;
        this.numberOrderItem = numberOrderItem;
        this.quantityOrder = quantityOrder;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberOrderItem() {
        return numberOrderItem;
    }

    public void setNumberOrderItem(int numberOrderItem) {
        this.numberOrderItem = numberOrderItem;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

  

    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getClassName() {
        return "order_item";
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAttributes() {
        return order.getId()+","+numberOrderItem+","+quantityOrder+","+product.getID();
    }

    @Override
    public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException {
        OrderItem orderItem = new OrderItem();
        
        orderItem.setNumberOrderItem(rs.getInt("numberOrder"));
        orderItem.setQuantityOrder(rs.getInt("quantity"));
        order.setId(rs.getInt("order_id"));
        
        
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
                
                orderItem.setProduct(product);
                return orderItem;
    }

    @Override
    public String getJoinCondition() {
        return "oi join product p on oi.product_id = p.product_id";
    }

    @Override
    public String getColumnNames() {
        return "(order_id,numberOrder,quantity,product_id)";
    }

    
    
}
