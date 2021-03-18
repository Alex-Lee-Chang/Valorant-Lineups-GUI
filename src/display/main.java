package display;

import lineup.*;
import lineup.Enums.*;

import javax.swing.*;


public class main
{

   public static void main(String[] args)
   {
      LineupFrame LineupFrame = new LineupFrame("Lineup App");
      LineupFrame.setSize(1024, 1024);
      LineupFrame.setLocationRelativeTo(null);
      LineupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      LineupFrame.setVisible(true);

      
      
      /*LineupTree viperTree = new LineupTree(Enums.agent.VIPER);
      viperTree.init();
      viperTree.populateFolders();
      viperTree.display();*/
      
      /*lineup writeLineup = new lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.ATTACK, Enums.site.A, Enums.projectile.MOLLY, Enums.throwType.THROW, Enums.land.DEFAULT, "viper2");
      lineup write2Lineup = new lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.ATTACK, Enums.site.A, Enums.projectile.MOLLY, Enums.throwType.THROW, Enums.land.GREEN_BOX, "viper1");
      lineup write3Lineup = new lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.DEFEND, Enums.site.B, Enums.projectile.MOLLY, Enums.throwType.THROW, Enums.land.DEFAULT, "viper3");
      FileUtility fileUtil = new FileUtility(Enums.agent.VIPER);
      fileUtil.writeLineup(writeLineup);
      fileUtil.writeLineup(write2Lineup);
      fileUtil.writeLineup(write3Lineup);*/
      
      
   }

}
