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
 * @author Korisnik
 */
public class Product extends GeneralDomainObject {
    
    private int ID;
    private String name;
    private int quantity;
    private MeasurementUnit measurementUnit;
    private Manufacturer manufacturer;
    private double priceWithoutVAT;
    private double priceWithVat;
    private String whereCondition = "0";
    private String setAttributes = "1";
    
    public Product() {
    }
    
    public Product(int ID, String name, int quantity, MeasurementUnit measurementUnit, Manufacturer manufacturer, double priceWithoutVat, double priceWithVat) {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
        this.manufacturer = manufacturer;
        this.priceWithoutVAT = priceWithoutVat;
        this.priceWithVat = priceWithVat;
        
    }
    
    public double getPriceWithoutVAT() {
        return priceWithoutVAT;
    }
    
    public void setPriceWithoutVAT(double priceWithoutVAT) {
        this.priceWithoutVAT = priceWithoutVAT;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }
    
    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
    
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public double getPriceWithVat() {
        return priceWithVat;
    }
    
    public void setPriceWithVat(double priceWithVat) {
        this.priceWithVat = priceWithVat;
    }
    
  

    @Override
    public String setAttributes() {
         if (setAttributes.equals("1")) {
            return "product_id =" + getID();
        } else {
            return "name='" + name + "', quantity =" +quantity+" "+ "measurement_unit = "+measurementUnit+" "
                    +"priceWithVat= "+priceWithVat+" "+"priceWithoutVat= "+priceWithoutVAT+"manufacturer_id= "+manufacturer.getId();
                  
        }
    }

    
    @Override
    public String getClassName() {
        return "product";
    }

    @Override
    public String getWhereCondition() {
         switch (whereCondition) {
            case "0":
                return " ";
            case "1":
                return " where product_id = " + ID;
            default:
                return "";
        }
    }
    

    @Override
    public String getAttributes() {
         return "'"+name+"'"+","+quantity+","+"'"+measurementUnit+"'"+","+priceWithVat+","+priceWithoutVAT+","+manufacturer.getId();
    }

    @Override
    public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException {
       
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
                
                Manufacturer manu = new Manufacturer();
                int ManuId = rs.getInt("mf.manufacturer_id");
                manu.setId(ManuId);
                String ManuName = rs.getString("mf.name");
                manu.setName(ManuName);
                product.setManufacturer(manufacturer);
                
               
       return product;
    }

    @Override
    public String getColumnNames() {
        return "(name,quantity,measurement_unit,priceWithVat,priceWithoutVat,manufacturer_id)";
    }
    

    public String getSetAttributes() {
        return setAttributes;
    }

    public void setSetAttributes(String setAttributes) {
        this.setAttributes = setAttributes;
    }

    @Override
    public String getJoinCondition() {
        return " p join manufacturer mf on mf.manufacturer_id = p.manufacturer_id";
    }

    @Override
    public void setPrimaryKey(ResultSet rs) throws SQLException {
       ID = rs.getInt(1);
    }
 
    
    
}
