/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gordonman
 */
public class GridBagExample {
    JFrame frame = new JFrame();
    JPanel pane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    JTextField atf = new JTextField();
    JButton add = new JButton("ADD");
    String getValue = null;
    
    public GridBagExample()
    {
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10,10,10,10);
        pane.add(add, c);
        c.gridx = 1;
        c.gridy = 0;
        pane.add(new JButton("REMOVE"), c);
        c.gridx = 0;
        c.gridy = 1;
        pane.add(new JButton("Hello"), c);
        c.gridx = 1;
        c.gridy = 1;
        pane.add(new JLabel("World"), c);
        c.gridx = 0;
        c.gridy = 2;
        pane.add(atf, c);
        frame.setSize(600,200);
        frame.getContentPane().add(pane);
        frame.setVisible(true);
        
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
               getValue = atf.getText();
               System.out.println(getValue);
               atf.setText("");
            }
         });
                
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 2; x++)
            {
                System.out.println(x + " " + y);
            }
        }
        System.out.println(getValue);
    }
    
    public static void main(String args[])
    {
        GridBagExample gb = new GridBagExample();
        
    }
}
