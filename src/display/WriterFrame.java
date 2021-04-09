package display;
import java.awt.*;
import lineup.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import display.LineupFrame.phase;

class WriterFrame extends JFrame implements Enums
{
   private phase currentPhase;
   
   private JPanel buttonPanel;
   private JButton[] buttons = new JButton[18];


   public WriterFrame(String title)
   {
      super(title);

      buttonPanel = new JPanel(new GridLayout(2, 9, 10, 10));
      buttonPanel.setBorder(new TitledBorder("Select the Specification"));
      
      setLayout(new BorderLayout(20, 10));
      add(buttonPanel, BorderLayout.NORTH);

      currentPhase = LineupFrame.phase.AGENT;
      
      for(int i = 0; i < buttons.length; ++i) 
         buttons[i] = new JButton();
      
      updateButtons();

      setVisible(true);
   }
   
   private void updateButtons() //TODO
   {
      String name;
      int length;
      
      switch(currentPhase) 
      {
      case AGENT:
         break;
      case MAP:
         break;
      case SIDE:
         break;
      case SITE:
         break;
      case PROJECTILE:
         break;
      case THROW_TYPE:
         break;
      case LANDS:
         break;
      case IMAGE:
         break;
      case DONE:
         break;
      default:
         break;
      }
      
      for(int i = 0; i < Enums.agent.values().length; ++i) 
      {
         name = Enums.agent.values()[i].toString();
         name = name.substring(0, 1) + name.substring(1).toLowerCase();
         buttons[i].setText(name);
         buttonPanel.add(buttons[i]);
      }
   }
   
}
