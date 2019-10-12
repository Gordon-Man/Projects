package database;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GBL 
{
      public void createAndShowUI(JPanel panel, JLabel[] labelArray) {
      panel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1.0;  // **** comment this line out to see effect ****
      gbc.weighty = 1.0;  // **** comment this line out to see effect ****

      for (int i = 0; i < labelArray.length; i++) {
         gbc.gridy = i;
         panel.add(labelArray[i], gbc);
      }
   }
}