package display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lineup.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class LineupFrame extends JFrame implements Enums
{
   private enum phase
   {
      AGENT, MAP, SIDE, SITE, DONE
   };

   private static String[] agentArray = new String[Enums.agent.values().length];
   private static String[] mapArray = new String[Enums.map.values().length];
   private static String[] siteArray = new String[Enums.site.values().length];
   private boolean arraysSet = false;
   private boolean treesSet = false;
   private phase currentPhase;
   private Enums.agent agent;
   private Enums.map map;
   private Enums.side side;
   private Enums.site site;

   private LineupTree[] lineupTrees = new LineupTree[9];
   private LineupNode currentLineup;
   
   private JPanel imagePanel;
   private JPanel buttonPanel;
   private JPanel selectedInfoPanel;
   private JPanel specificInfoPanel;
   private JPanel infoPanel;

   private JLabel selectedAgent, selectedMap, selectedSide, selectedSite;

   private JLabel projectile, land, throwType;

   private JLabel image;
   private JPanel imageButtonPanel;
   private JButton nextImageButton, previousImageButton;

   private JButton backSelectButton;
   private JButton sovaB, viperB, brimstoneB, killjoyB, sageB, cypherB, phoenixB, yoruB, razeB;
   private JButton ascentB, bindB, havenB, iceboxB, splitB;
   private JButton attackB, defendB;
   private JButton aB, bB, cB, midB, garageB;

   public LineupFrame(String title)
   {
      super(title);

      imagePanel = new JPanel(new BorderLayout(10, 10));
      imageButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));
      buttonPanel = new JPanel(new GridLayout(2, 5, 10, 10));
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

      selectedAgent = new JLabel("Agent: ");
      selectedMap = new JLabel("Map: ");
      selectedSide = new JLabel("Side: ");
      selectedSite = new JLabel("Site: ");

      selectedInfoPanel.add(selectedAgent);
      selectedInfoPanel.add(selectedMap);
      selectedInfoPanel.add(selectedSide);
      selectedInfoPanel.add(selectedSite);

      projectile = new JLabel("Projectile: ");
      land = new JLabel("Lands: ");
      throwType = new JLabel("Throw Type: ");

      specificInfoPanel.add(projectile);
      specificInfoPanel.add(land);
      specificInfoPanel.add(throwType);

      prevNextListener prevNextListener = new prevNextListener();
      nextImageButton = new JButton("Next");
      nextImageButton.addActionListener(prevNextListener);
      previousImageButton = new JButton("Previous");
      previousImageButton.addActionListener(prevNextListener);
      nextImageButton.setPreferredSize(new Dimension(85, 30));
      previousImageButton.setPreferredSize(new Dimension(85, 30));
      image = new JLabel();

      imagePanel.add(imageButtonPanel, BorderLayout.PAGE_END);
      imageButtonPanel.add(previousImageButton);
      imageButtonPanel.add(nextImageButton);
      imagePanel.add(image, BorderLayout.NORTH);

      backButtonListener listener = new backButtonListener();
      backSelectButton = new JButton("Back");
      backSelectButton.addActionListener(listener);

      currentPhase = phase.AGENT;
      initTrees();
      initButtons();
      showAgentButtons();

      setArrays();

      setVisible(true);
   }

   public void update()
   {
      switch (currentPhase)
      {
      case AGENT:
         agent = null;
         map = null;
         side = null;
         site = null;
         currentLineup = null;
         updateSelectedText();
         showAgentButtons();
         break;
      case MAP:
         map = null;
         side = null;
         site = null;
         currentLineup = null;
         updateSelectedText();
         showMapButtons();
         break;
      case SIDE:
         side = null;
         site = null;
         currentLineup = null;
         updateSelectedText();
         showSideButtons();
         break;
      case SITE:
         site = null;
         currentLineup = null;
         updateSelectedText();
         showSiteButtons();
         break;
      case DONE:
         if(currentLineup == null) 
         {
            int index = getIndex(agentArray, agent.toString());
            lineup lineup = new lineup(agent, map, side, site);
            currentLineup = lineupTrees[index].find(lineup).getChild();
         }
         updateSelectedText();
         showLineup();
         
         break;
      default:
         break;
      }
   }

   private void updateSelectedText() 
   {
      projectile.setText("Projectile: ");
      land.setText("Lands: ");
      throwType.setText("ThrowType: ");
      image.removeAll();
      image.revalidate();
      image.repaint();
      image.setIcon(new ImageIcon());
      
      if(agent == null)
         selectedAgent.setText("Agent: ");
      else
         selectedAgent.setText("Agent: " + agent.toString());
      
      if(map == null)
         selectedMap.setText("Map: ");
      else
         selectedMap.setText("Map: " + map.toString());
      
      if(side == null)
         selectedSide.setText("Side: ");
      else
         selectedSide.setText("Side: " + side.toString());
      
      if(site == null)
         selectedSite.setText("Site: ");
      else
         selectedSite.setText("Site: " + site.toString());

   }
   
   private void initButtons()
   {
      agentButtonListener listener = new agentButtonListener();
      sovaB = new JButton("Sova");
      sovaB.addActionListener(listener);
      viperB = new JButton("Viper");
      viperB.addActionListener(listener);
      brimstoneB = new JButton("Brimstone");
      brimstoneB.addActionListener(listener);
      killjoyB = new JButton("Killjoy");
      killjoyB.addActionListener(listener);
      sageB = new JButton("Sage");
      sageB.addActionListener(listener);
      cypherB = new JButton("Cypher");
      cypherB.addActionListener(listener);
      phoenixB = new JButton("Phoenix");
      phoenixB.addActionListener(listener);
      yoruB = new JButton("Yoru");
      yoruB.addActionListener(listener);
      razeB = new JButton("Raze");
      razeB.addActionListener(listener);

      mapButtonListener mapListener = new mapButtonListener();
      ascentB = new JButton("Ascent");
      ascentB.addActionListener(mapListener);
      bindB = new JButton("Bind");
      bindB.addActionListener(mapListener);
      havenB = new JButton("Haven");
      havenB.addActionListener(mapListener);
      iceboxB = new JButton("Icebox");
      iceboxB.addActionListener(mapListener);
      splitB = new JButton("Split");
      splitB.addActionListener(mapListener);
      
      sideButtonListener sideListener = new sideButtonListener();
      attackB = new JButton("Attack");
      attackB.addActionListener(sideListener);
      defendB = new JButton("Defence");
      defendB.addActionListener(sideListener);
      
      siteButtonListener siteListener = new siteButtonListener();
      aB = new JButton("A");
      aB.addActionListener(siteListener);
      bB = new JButton("B");
      bB.addActionListener(siteListener);
      cB = new JButton("C");
      cB.addActionListener(siteListener);
      midB = new JButton("Mid");
      midB.addActionListener(siteListener);
      garageB = new JButton("Garage");
      garageB.addActionListener(siteListener);
      
   }

   private void clearButtonPanel() 
   {
      buttonPanel.removeAll();
      buttonPanel.revalidate();
      buttonPanel.repaint();
   }
   private void showAgentButtons()
   {
      clearButtonPanel();
      buttonPanel.add(sovaB);
      buttonPanel.add(viperB);
      buttonPanel.add(brimstoneB);
      buttonPanel.add(killjoyB);
      buttonPanel.add(sageB);
      buttonPanel.add(cypherB);
      buttonPanel.add(phoenixB);
      buttonPanel.add(yoruB);
      buttonPanel.add(razeB);
      buttonPanel.add(backSelectButton);
   }

   private void showMapButtons()
   {
      clearButtonPanel();
      buttonPanel.add(ascentB);
      buttonPanel.add(bindB);
      buttonPanel.add(havenB);
      buttonPanel.add(iceboxB);
      buttonPanel.add(splitB);
      buttonPanel.add(backSelectButton);
   }
   
   private void showSideButtons() 
   {
      clearButtonPanel();
      buttonPanel.add(attackB);
      buttonPanel.add(defendB);
      buttonPanel.add(backSelectButton);
   }
   
   private void showSiteButtons() 
   {
      clearButtonPanel();
      buttonPanel.add(aB);
      buttonPanel.add(bB);
      
      if(map == null)
         return;
      
      if(map != Enums.map.BIND)
         buttonPanel.add(midB);
      
      if(map == Enums.map.HAVEN) 
      {
         buttonPanel.add(cB);
         buttonPanel.add(garageB);
      }
      
      buttonPanel.add(backSelectButton);
   }
   
   private void showLineup() 
   {
      if(currentLineup == null) 
      {
         image.setText("No Lineups Found");
         return;
      }
      
      image.setText("");
      projectile.setText("Projectile: " + currentLineup.getData().getProjectile());
      land.setText("Lands: " + currentLineup.getData().getLand());
      if(currentLineup.getData().getSecondThrowType() == null)
         throwType.setText("Throw Type: " + currentLineup.getData().getThrowType());
      else
         throwType.setText("Throw Type: " + currentLineup.getData().getThrowType() + " then " + currentLineup.getData().getSecondThrowType());
      
      String imageName = "images/";
      imageName += agent.toString().toLowerCase() + "/";
      imageName += currentLineup.getData().getImage();
      
      image.setIcon(new ImageIcon(imageName));
   }


   class backButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (currentPhase == phase.AGENT)
            return;

         for (int i = 0; i < phase.values().length; ++i)
         {
            if (phase.values()[i] == currentPhase)
            {
               if(i == 4)
                  currentPhase = phase.values()[i - 2];
               else
                  currentPhase = phase.values()[i - 1];
            }
         }
         update();
      }
   }

   class agentButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton button = (JButton) e.getSource();
         String name = button.getText();
         int index = getIndex(agentArray, name);
         agent = Enums.agent.values()[index];
         currentPhase = phase.MAP;
         update();
      }
   }

   class mapButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton button = (JButton) e.getSource();
         String mapName = button.getText();
         int index = getIndex(mapArray, mapName);
         map = Enums.map.values()[index];
         currentPhase = phase.SIDE;
         update();
      }
   }
   
   class sideButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) 
      {
         JButton button = (JButton) e.getSource();
         if(button == attackB) 
            side = Enums.side.ATTACK;
         else
            side = Enums.side.DEFEND;
         currentPhase = phase.SITE;
         update();
            
      }
   }
   
   class siteButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) 
      {
         JButton button = (JButton) e.getSource();
         String siteName = button.getText();
         int index = getIndex(siteArray, siteName);
         site = Enums.site.values()[index];
         currentPhase = phase.DONE;
         currentLineup = null;
         update();
      }
   }
   
   class prevNextListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) 
      {
         JButton button = (JButton) e.getSource();
         LineupNode temp;
         
         if(currentLineup == null || currentPhase != phase.DONE)
            return;
         
         if(button == previousImageButton) 
         {
            if(currentLineup.getPrev().getSib() == currentLineup) 
               currentLineup = currentLineup.getPrev();
               
         }
         else if(button == nextImageButton) 
         {
            if((temp = currentLineup.getSib()) != null)
               currentLineup = temp;
         }
         update();
      }
   }
   
   
   private void initTrees() 
   {
      if(treesSet)
         return;
      
      for(int i = 0; i < lineupTrees.length; ++i) 
      {
         lineupTrees[i] = new LineupTree(Enums.agent.values()[i]);
         lineupTrees[i].init();
         lineupTrees[i].populateFolders();
      }
      treesSet = true;
   }
   
   private void setArrays()
   {
      if (arraysSet)
         return;
      for (int i = 0; i < agentArray.length; ++i)
         agentArray[i] = Enums.agent.values()[i].name();

      for (int i = 0; i < mapArray.length; ++i)
         mapArray[i] = Enums.map.values()[i].name();

      for (int i = 0; i < siteArray.length; ++i)
         siteArray[i] = Enums.site.values()[i].name();

      arraysSet = true;
   }

   private int getIndex(String[] array, String string)
   {
      for (int i = 0; i < array.length; ++i)
      {
         if (array[i].equalsIgnoreCase(string))
         {
            return i;
         }
      }
      return -1;
   }

}
