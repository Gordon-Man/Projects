//this class is meant for handling the resizing of a window that shows the result set table.
//resizing the window with compadapter extension will resize the result set table too.
package database;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CompAdapter extends ComponentAdapter {
    Dimension size = null;
    JPanel pane = null;
    JScrollPane scrollPane = null;
    
    public CompAdapter()
    {}
    
    public CompAdapter(JPanel pane, JScrollPane scrollPane)
    {
        this.pane = pane;
        this.scrollPane = scrollPane;
    }
    
    @Override
    public void componentResized(ComponentEvent e)
    {
        size = pane.getSize();
        size.height = 400;//size.height/2;
        scrollPane.setSize(size);
    }
}
