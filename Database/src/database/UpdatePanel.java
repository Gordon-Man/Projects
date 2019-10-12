package database;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UpdatePanel
{
    JPanel updatePane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    JScrollPane scrollPane = new JScrollPane();
    JLabel[] labels = null;
    JTextField[] tf = null;
    JButton add = new JButton("ADD");
    JButton delete = new JButton("REMOVE");
    String tableName;
    
    public UpdatePanel(Vector<String> columnNames, String tableName)
    {
        labels = new JLabel[columnNames.size()];
        tf = new JTextField[columnNames.size()];
        this.tableName = tableName;
        updatePane.setBorder(BorderFactory.createLineBorder(Color.black));
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10,10,10,10); // north / left / south / right
        for (int y = 0; y < columnNames.size(); y++)
        {
            labels[y] = new JLabel(columnNames.get(y)+ ":");
            tf[y] = new JTextField(10);
            for (int x = 0; x < 2; x++)
            {
                c.gridx = x;
                c.gridy = y;
                if (x == 0)
                    updatePane.add(labels[y], c);
                else
                    updatePane.add(tf[y], c);
            }
        }
        c.insets = new Insets(10, 10, 10, 5);
        c.gridx = 0;
        c.gridy = columnNames.size() + 1;
        updatePane.add(add, c);
        c.gridx = 1;
        updatePane.add(delete, c);
    }
    
    public String getAddValues(UpdatePanel up)
    {
        
        String query = "INSERT INTO `" + up.tableName + "` (";
        
        for(int i = 1; i < up.labels.length; i++)
        {
            query += "`" + labels[i].getText() + ", ";
            query = query.replaceAll(":", "`");
        }
        
        query = query.substring(0, query.length() - 2) + ")";
        query += "\nVALUE(";
        for (int i = 1; i < up.tf.length; i++)
        {
            query += "\"" + tf[i].getText() + "\", ";
            tf[i].setText("");
        }
        tf[0].setText("");
        
        query = query.substring(0, query.length() - 2) + ");";
        
        System.out.println(query);
        return query;
    }
    
    public String removeRow(UpdatePanel up)
    {
        String query;
        
        query = "DELETE FROM `" + up.tableName + "` WHERE `";
        query += labels[0].getText() + "` = " + tf[0].getText();
        query = query.replaceAll(":", "");
        tf[0].setText("");
        System.out.println(query);
        return query;
    }
}

/*
INSERT INTO `Products` (`Brand ID`, `Brand`, `Species`, `Dimensions`, `Texture`, `Listing Price`)
VALUES('ET1234568', 'Eternity', 'Brazilian Cherry', '4 1/2 x 7 x 3/4', 'Distressed', '3.79');

DELETE FROM `Products` WHERE `Product ID` = integer
*/