/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Katica
 */
public class Order extends GeneralDomainObject{

    private int id;
    private Date orderDate;
    private Guest guest;

    private ArrayList<OrderItem> orderItems;

    public Order() {
        orderItems = new ArrayList<>();
        
    }

    public Order(int id, Date orderDate, ArrayList<OrderItem> orderItems,Guest guest) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.guest = guest;
    }
    
    

    public Order(int id, Date orderDate,Guest guest) {
        this.id = id;
        this.orderDate = orderDate;
        this.guest = guest;
        orderItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getClassName() {
        return "order_order";
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAttributes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        return "'"+(new java.sql.Date(orderDate.getTime()) +"'"+ ","+guest.getId());
    }

    @Override
    public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException {
        Order order = new Order();
        
        order.setOrderDate(rs.getDate("date_order"));
        order.setId(rs.getInt("order_id"));
        
        Guest guest = new Guest();
        guest.setId(rs.getInt("id"));
        guest.setFirstName(rs.getString("firstName"));
        guest.setLastName(rs.getString("lastName"));
        guest.setEmail(rs.getString("email"));
        guest.setTelephone(rs.getString("telephone"));
        
        order.setGuest(guest);
        
        return order;
        
    }

    @Override
    public String getColumnNames() {
        return "(date_order,guest_id)";
    }

    @Override
    public String getJoinCondition() {
        return "o join guest g on o.guest_id = g.id";
    }

    @Override
    public void setPrimaryKey(ResultSet rs) throws SQLException {
        id = rs.getInt(1);
    }
    
    

}
