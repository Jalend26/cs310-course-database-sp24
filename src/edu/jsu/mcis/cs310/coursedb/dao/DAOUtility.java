package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                
                ResultSetMetaData meta = rs.getMetaData();
                int count = meta.getColumnCount();
                
                while (rs.next()) {
                    
                    JsonObject object = new JsonObject();
                    
                    for (int i = 1; i <= count; i++) {
                        
                        Object value = rs.getObject(i);
                        String name = meta.getColumnName(i);
                        
                        object.put(name, value.toString());
  
                    }
                    
                    records.add(object);
                    
                }
                

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
