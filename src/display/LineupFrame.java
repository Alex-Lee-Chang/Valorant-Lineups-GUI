package display;
import java.awt.*;
import lineup.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class LineupFrame extends JFrame implements Enums
{
   private JPanel imagePanel;
   private JPanel buttonPanel;
   private JPanel selectedInfoPanel;
   private JPanel specificInfoPanel;
   private JPanel infoPanel;

   public JLabel selectedMap, selectedAgent, selectedSide, selectedSite;
   
   public JLabel projectile, land, throwType;
   
   public JLabel image;
   private JButton nextImageButton, previousImageButton;

   public LineupFrame(String title)
   {
      super(title);

      imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      buttonPanel = new JPanel(new GridLayout(1, 9, 10, 10));
      selectedInfoPanel = new JPanel(new GridLayout(1, 4, 10, 10));
      specificInfoPanel = new JPanel(new GridLayout(1, 3, 10, 10));
      infoPanel = new JPanel(new GridLayout(2, 1, 10, 10));
      
      imagePanel.setBorder(new TitledBorder("Lineup Image"));
      buttonPanel.setBorder(new TitledBorder("Select Your Option"));
      selectedInfoPanel.setBorder(new TitledBorder("Selected Specifications"));
      specificInfoPanel.setBorder(new TitledBorder("Lineup Details"));

      setLayout(new BorderLayout(20, 10));
      add(selectedInfoPanel, BorderLayout.NORTH);
      add(imagePanel, BorderLayout.CENTER);
      add(infoPanel, BorderLayout.SOUTH);
      infoPanel.add(specificInfoPanel, BorderLayout.NORTH);
      infoPanel.add(buttonPanel, BorderLayout.SOUTH);
      
      
      selectedMap = new JLabel("Map: ");
      selectedAgent = new JLabel("Agent: ");
      selectedSide = new JLabel("Side: ");
      selectedSite = new JLabel("Site: ");
      
      selectedInfoPanel.add(selectedMap);
      selectedInfoPanel.add(selectedAgent);
      selectedInfoPanel.add(selectedSide);
      selectedInfoPanel.add(selectedSite);

      
      projectile = new JLabel("Projectile: ");
      land = new JLabel("Lands: ");
      throwType = new JLabel("Throw Type: ");
    		  
      specificInfoPanel.add(projectile);
      specificInfoPanel.add(land);
      specificInfoPanel.add(throwType);
      
      nextImageButton = new JButton("Next");
      previousImageButton = new JButton("Previous");
      nextImageButton.setPreferredSize(new Dimension(100, 40));
      previousImageButton.setPreferredSize(new Dimension(100, 40));
      image = new JLabel();
      
      imagePanel.add(nextImageButton);
      imagePanel.add(image);
      imagePanel.add(previousImageButton);
      
      setVisible(true);
   }
}
