/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author gordonman
 */
public class ResultSetData 
{
    Vector<String> columnNames = new Vector<String>();
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    
    public ResultSetData(ResultSetMetaData metaData, ResultSet rs)
    {
        try
        {
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) 
            {
                columnNames.add(metaData.getColumnName(column));
            }
            while (rs.next()) 
            {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
                {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
        } catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public Vector<String> getVector()
    {
       return this.columnNames;
    }
}
