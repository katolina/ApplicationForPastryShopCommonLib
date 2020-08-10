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
 * @author Korisnik
 */
public class Manufacturer extends GeneralDomainObject {
    private int id;
    private String name;

    public Manufacturer() {
        
    }

    public Manufacturer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String setAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getClassName() {
        return "manufacturer";
    }

    @Override
    public String getWhereCondition() {
        return "";
    }

    @Override
    public String getAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException {
        Manufacturer m = new Manufacturer();
        m.setId(rs.getInt("manufacturer_id"));
        m.setName(rs.getString("name"));

        return m;
        }

  
    
}
