package display;
import java.awt.*;
import lineup.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class writerDisplay extends JFrame implements Enums
{
   private JPanel buttonPanel;



   public writerDisplay(String title)
   {
      super(title);

      buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
      
      
      buttonPanel.setBorder(new TitledBorder("Select the Specification"));

      setLayout(new BorderLayout(20, 10));
      add(buttonPanel, BorderLayout.NORTH);


      setVisible(true);
   }
}
