
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DatabasePanel extends JPanel
{
    Statement stmt          = null;
    ResultSet rs            = null;
    Connection conn         = null;
    JScrollPane scrollPane  = null;
    JTable table            = null;
    UpdatePanel updatePanel = null;
    Dimension panelSize     = new Dimension(864, 819);
    Dimension size          = null;
    Font button             = new Font("Montserrat", Font.PLAIN, 22);
    String tableName        = null;
    
    public DatabasePanel(String table)
    {
        this.tableName = table;
    }
    
    public void setDB()
    {
        // create a new connection to GEW DB
        try
        {
            conn = ConnectDB.getConnection();
            System.out.println(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
            
            //Creating Query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData metaData = rs.getMetaData();
            
            //class for storing all the data into a vector of vectors. set.data/set.columnNames
            ResultSetData set = new ResultSetData(metaData, rs);
            
            //Modify Table
            table = new JTable(set.data, set.columnNames);
            table.setGridColor(Color.BLACK);
            table.setFont(new Font("Serif", Font.PLAIN, 15));
            table.setRowHeight(20);
            table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
            
            //Create Add/Remove Panel
            updatePanel = new UpdatePanel(set.getVector(), tableName);
            updatePanel.updatePane.setBounds(25, 435, 250, 350);
            
            //Modify Scroll Pane
            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 0, 864, 400);

            //Set the JPanel
            this.setLayout(null);
            this.setPreferredSize(panelSize);
            this.add(scrollPane); 
            this.add(updatePanel.updatePane);
            this.addComponentListener(new CompAdapter(this, scrollPane));
  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally 
        {
            try
            {
               if (conn != null)
               {
                    conn.close();
                    System.out.println("Connection has been closed");
               }
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        drawButton(g, 725, 725, "Back", 25, 35);   
    }
   
    void drawButton(Graphics g, int x, int y, String button_name, int paddingX, int paddingY)
    {
        g.setFont(button);
        g.drawRect(x, y, 100, 50);
        g.drawString(button_name, x + paddingX, y + paddingY);
    }
    
    public void adjustRecord(String operation)
    {
        try
        {
            conn = ConnectDB.getConnection();
            System.out.println(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
            
            //Creating Query
            stmt = conn.createStatement();
            
            String query;
            if (operation.compareTo("add") == 0)
                query = updatePanel.getAddValues(updatePanel);
            else
                query = updatePanel.removeRow(updatePanel);
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally 
        {
            try
            {
               if (conn != null)
               {
                    conn.close();
                    System.out.println("Connection has been closed");
               }
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }   
    }
    
    public void updateDB(DatabasePanel db)
    {
        try
        {
            conn = ConnectDB.getConnection();
            System.out.println(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
            
            //Creating Query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData metaData = rs.getMetaData();
            
            //class for storing all the data into a vector of vectors. set.data/set.columnNames
            ResultSetData set = new ResultSetData(metaData, rs);
            
            //Modify Table
            table = new JTable(set.data, set.columnNames);
            table.setGridColor(Color.BLACK);
            table.setFont(new Font("Serif", Font.PLAIN, 15));
            table.setRowHeight(20);
            table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
            
            db.scrollPane.setVisible(false);
            db.remove(db.scrollPane);
            db.scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 0, 864, 400);

            
            //Set the JPanel
            db.setLayout(null);
            db.setPreferredSize(panelSize);
            db.add(scrollPane); 
            db.scrollPane.setVisible(true);
            db.addComponentListener(new CompAdapter(this, scrollPane));
  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally 
        {
            try
            {
               if (conn != null)
               {
                    conn.close();
                    System.out.println("Connection has been closed");
               }
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}

/*
Query for inserting into Products table:

INSERT INTO `Products` (`Brand ID`, `Brand`, `Species`, `Dimensions`, `Texture`, `Listing Price`)
VALUES('ET1234568', 'Eternity', 'Brazilian Cherry', '4 1/2 x 7 x 3/4', 'Distressed', '3.79');

Query for inserting into Products table

IINSERT INTO `Products` (`Brand ID`, `Brand`, `Species`, `Dimensions`, `Texture`, `Listing Price`)
VALUES('ET1234568', 'Eternity', 'Brazilian Cherry', '4 1/2 x 7 x 3/4', 'Distressed', '3.79');



CREATE TABLE Orders
(
    `OrderID` integer AUTO_INCREMENT,
    `CustomerUUID` VARCHAR(30) NOT NULL,
    `ProductUUID` VARCHAR(30) NOT NULL,
    `Brand` VARCHAR(30),
    `SqFt` integer,
    `Date` TIMESTAMP,
    PRIMARY KEY (`OrderID`),
    FOREIGN KEY (`CustomerUUID`) REFERENCES Customers(`CustomerUUID`),
    FOREIGN KEY (`ProductUUID`) REFERENCES Products(`ProductUUID`)
);
*/