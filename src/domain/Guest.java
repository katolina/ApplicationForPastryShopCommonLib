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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katica
 */
public class Guest extends GeneralDomainObject{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;

    public Guest() {
    }

    public Guest(int id, String firstName, String lastName, String email, String telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
       return firstName+" "+lastName;
    }


    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getClassName() {
        return "guest";
    }

    @Override
    public String getWhereCondition() {
         return "";
    }

    @Override
    public String getAttributes() {
        return "'"+firstName +"'"+ ","+"'"+lastName+"'"+","+"'"+ email+ "'"+","+"'"+telephone+"'";
    }

    @Override
    public String getColumnNames() {
        return "(firstName, lastName, email, telephone)";
    }

    @Override
    public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException {
        Guest guest = new Guest();

        guest.setId(rs.getInt("id"));
        guest.setFirstName(rs.getString("firstName"));
        guest.setLastName(rs.getString("lastName"));
        guest.setEmail(rs.getString("email"));
        guest.setTelephone(rs.getString("telephone"));
       
        return guest;
    }

    @Override
    public void setPrimaryKey(ResultSet rs) throws SQLException {
        id = rs.getInt(1);
    }
    
    
}
