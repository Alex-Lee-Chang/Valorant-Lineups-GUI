package display;
import java.awt.*;
import lineup.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class LineupFrame extends JFrame implements Enums
{
   public JPanel ImagePanel;
   public JPanel ButtonPanel;
   public JPanel SelectedInfoPanel;
   public JPanel SpecificInfoPanel;
   public JPanel InfoPanel;



   public LineupFrame(String title)
   {
      super(title);

      ImagePanel = new JPanel(new GridLayout(1, 1, 10, 10));
      ButtonPanel = new JPanel(new GridLayout(1, 9, 10, 10));
      SelectedInfoPanel = new JPanel(new GridLayout(1, 4, 10, 10));
      SpecificInfoPanel = new JPanel(new GridLayout(1, 3, 10, 10));
      InfoPanel = new JPanel(new GridLayout(2, 1, 10, 10));
      
      
      ImagePanel.setBorder(new TitledBorder("Lineup Image"));
      ButtonPanel.setBorder(new TitledBorder("Select Your Option"));
      SelectedInfoPanel.setBorder(new TitledBorder("Selected Specifications"));
      SpecificInfoPanel.setBorder(new TitledBorder("Lineup Details"));

      setLayout(new BorderLayout(20, 10));
      add(SelectedInfoPanel, BorderLayout.NORTH);
      add(ImagePanel, BorderLayout.CENTER);
      add(InfoPanel, BorderLayout.SOUTH);
      InfoPanel.add(SpecificInfoPanel, BorderLayout.NORTH);
      InfoPanel.add(ButtonPanel, BorderLayout.SOUTH);


      setVisible(true);
   }
}
