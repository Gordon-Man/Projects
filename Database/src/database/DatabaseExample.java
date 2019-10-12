
package database;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DatabaseExample {
    JFrame frame = new JFrame();
    JScrollPane scrollPane = null;
    JTable table = null;
    JPanel pane = null;
    Dimension panelSize = new Dimension(864, 819);
    
    public DatabaseExample()
    {
        
        Object[][] data = 
        {
            {"Kathy", "Smith",
             "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
             "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
             "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
             "Speed reading and CrossFit", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
             "Pool", new Integer(10), new Boolean(false)}
        };
        String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};  
        
        //Modify Table
        table = new JTable(data, columnNames);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.setRowHeight(20);
        table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
        
        //Modify Scroll Pane
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 864, 425);
        
        //Modify Pane
        pane = new JPanel();
        pane.setLayout(null);
        pane.setPreferredSize(panelSize);
        pane.add(scrollPane);
        
        //Frame
        pane.addComponentListener(new myAdapter());
        frame.add(pane);
        frame.setVisible(true);
        frame.pack();
    }
    
    class myAdapter extends ComponentAdapter
    {
        Dimension size = new Dimension(pane.getSize());
        @Override
        public void componentResized(ComponentEvent e)
        {
            size = pane.getSize();
            size.height = size.height/2;
            scrollPane.setSize(size);
        }
    }
    
    public static void main(String args[])
    {
        DatabaseExample db = new DatabaseExample();
    }
}