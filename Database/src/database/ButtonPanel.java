




























package database;

import java.awt.Graphics;
import javax.swing.*;

public class ButtonPanel extends JPanel {
    
    private JButton button;

    public ButtonPanel(String button_name, int x, int y)
    {

        button = new JButton("Hey");    
        this.add(button);
//        button.setBorder(BorderFactory.createEmptyBorder());
//        button.setContentAreaFilled(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw buttons
        g.setColor(java.awt.Color.BLACK);
        g.drawRect(0,0,50,50);
        g.drawString("Hey", 100, 100);
    }
}
