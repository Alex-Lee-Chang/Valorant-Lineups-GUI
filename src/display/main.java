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

      
      
      /*LineupTree sovaTree = new LineupTree(Enums.agent.SOVA);
      sovaTree.init();
      
      lineup writeLineup = new lineup(Enums.agent.SOVA, Enums.map.ASCENT, Enums.side.ATTACK, Enums.site.A, Enums.projectile.SHOCK_DART, Enums.throwType.ONE_NO_BOUNCE, Enums.land.DEFAULT, "Pencil.jpg");
      lineup writeLineup2 = new lineup(Enums.agent.SOVA, Enums.map.BIND, Enums.side.DEFEND, Enums.site.B, Enums.projectile.SHOCK_DART, Enums.throwType.ONE_NO_BOUNCE, Enums.throwType.TAP_NO_BOUNCE, Enums.land.DEFAULT, "Pencil.jpg");
      FileUtility fileUtil = new FileUtility(Enums.agent.SOVA);
      fileUtil.writeLineup(writeLineup);
      fileUtil.writeLineup(writeLineup2);
      sovaTree.populateFolders();
      
      sovaTree.display();*/
      
   }

}
