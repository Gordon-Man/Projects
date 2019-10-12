package database;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuPanel extends JPanel
{
    private Image img;
    Dimension size;
    Font title = new Font("Montserrat", Font.PLAIN, 70);
    Font address = new Font("Montserrat", Font.PLAIN, 12);
    Font button = new Font("Montserrat", Font.PLAIN, 32);
    
    
    public MenuPanel() 
    {
      this(new ImageIcon("/Users/gordonman/NetBeansProjects/Database/src/Images/background.jpg").getImage());
     
    }
    
    public MenuPanel(Image img) 
    {
        this.img = img;
    }
    
    public void setSize(MenuPanel m)
    {
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        this.size = size;
        m.setPreferredSize(size);
        m.setMinimumSize(size);
        m.setMaximumSize(size);
        m.setSize(size);
        m.setLayout(null);
    }    
    
    public Dimension getSize(MenuPanel m)
    {
        return m.size;
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        //draw background image
        g.drawImage(img, 0, 0, this); // see javadoc for more info on the parameters   
        g.setFont(title);
        
        //draw title
        g.drawString("GEW", 370, 100);
        g.setFont(address);
        g.drawString("44711 S Grimmer Blvd # A, Fremont, CA 94538", 300, 130);
        
        //draw buttons
        drawButton(g, 140, 200, "Samples", 60, 60);
        drawButton(g, 140, 350, "Products", 55, 60);
        drawButton(g, 490, 200, "Orders", 75, 60);
        drawButton(g, 490, 350, "Customers", 45, 60);
    }
   
    void drawButton(Graphics g, int x, int y, String button_name, int paddingX, int paddingY)
    {
        g.setFont(button);
        g.drawRect(x, y, 250, 100);
        g.drawString(button_name, x + paddingX, y + paddingY);
    }
}

