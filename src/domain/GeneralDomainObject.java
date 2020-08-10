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
public abstract class GeneralDomainObject implements Serializable {
    abstract public String setAttributes();
    abstract public String getClassName();
    abstract public String getWhereCondition();
    abstract public String getAttributes();
    abstract public GeneralDomainObject getNewObj(ResultSet rs) throws SQLException;
    public String getJoinCondition() {
        return "";
    }
    public void setParent(GeneralDomainObject entity) {
    }
    public void setPrimaryKey(ResultSet rs) throws SQLException {
    }
    public String getColumnNames() {
        return "";
    }

   
}
