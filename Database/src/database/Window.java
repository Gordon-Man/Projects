package database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class Window 
{   
    public Window()
    {
        JFrame frame = new JFrame("GEW Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MenuPanel menu = new MenuPanel();
        menu.setSize(menu);
        frame.getContentPane().add(menu);
        frame.setResizable(false);
        DatabasePanel customers = new DatabasePanel("Customers");
        customers.setDB();
        
        menu.addMouseListener(new MouseAdapter()
        { 
          @Override
          public void mousePressed(MouseEvent e) 
          { 
                int mx = e.getX();
                int my = e.getY();
                
                if (mouseOver(mx, my, 490, 350, 250, 100))
                {
                    menu.setVisible(false);
                    frame.setResizable(true);
                    DatabasePanel customers = new DatabasePanel("Customers");
                    customers.setDB();
                    frame.getContentPane().add(customers);
                    customers.updatePanel.add.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                           customers.adjustRecord("add");
                           customers.updateDB(customers);
                        }
                    });
                    customers.updatePanel.delete.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                           customers.adjustRecord("delete");
                           customers.updateDB(customers);
                        }
                    });
                    customers.addMouseListener(new MouseAdapter()
                    { 
                      @Override
                      public void mousePressed(MouseEvent e) 
                      { 
                            int mx = e.getX();
                            int my = e.getY();
                            if (mouseOver(mx, my, 725, 725, 100, 50))
                            {
                                customers.setVisible(false);
                                menu.setVisible(true);
                                frame.setPreferredSize(menu.getSize(menu));
                                frame.pack();
                                frame.setResizable(false);
                            }
                      }  
                    }); 
                }
                
                if (mouseOver(mx, my, 140, 350, 250, 100))
                {
                    menu.setVisible(false);
                    frame.setResizable(true);
                    DatabasePanel products = new DatabasePanel("Products");
                    products.setDB();
                    frame.getContentPane().add(products);
                    products.updatePanel.add.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                           products.adjustRecord("add");
                           products.updateDB(products);
                        }
                    });
                    products.updatePanel.delete.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                           products.adjustRecord("delete");
                           products.updateDB(products);
                        }
                    });
                    products.addMouseListener(new MouseAdapter()
                    { 
                      @Override
                      public void mousePressed(MouseEvent e) 
                      { 
                            int mx = e.getX();
                            int my = e.getY();
                            if (mouseOver(mx, my, 725, 725, 100, 50))
                            {
                                products.setVisible(false);
                                frame.setPreferredSize(menu.getSize(menu));
                                frame.pack();
                                frame.setResizable(false);
                                menu.setVisible(true);
                            }
                      }  
                    }); 
                }
          } 
        }); 
        
        customers.addMouseListener(new MouseAdapter()
        { 
          @Override
          public void mousePressed(MouseEvent e) 
          { 
                int mx = e.getX();
                int my = e.getY();
                if (mouseOver(mx, my, 725, 725, 100, 50))
                {
                    customers.setVisible(false);
                    menu.setVisible(true);
                    frame.setResizable(false);
                    frame.getContentPane().add(menu);
                }
          }  
        }); 
        
        frame.setVisible(true);
        frame.pack();
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) 
    {
        if (mx > x && mx < x + width)
            return my > y && my < y + height;
        else
            return false;
    }
    
    public static void main(String[] args) 
    {
        Window window = new Window();
    }
}




