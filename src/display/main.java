package display;

import lineup.*;
import lineup.Enums.*;

import javax.swing.*;


public class main
{

   public static void main(String[] args)
   {
      /*FileUtility fileWriter = new FileUtility(Enums.agent.VIPER);
      fileWriter.writeLineup(new Lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.DEFEND, Enums.site.A, Enums.projectile.MOLLY, Enums.throwType.THROW, Enums.land.DEFAULT, "viper6.jpg"));
      fileWriter.writeLineup(new Lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.DEFEND, Enums.site.A, Enums.projectile.MOLLY, Enums.throwType.THROW, Enums.land.SIDE_GENERATOR, "viper7.jpg"));
      fileWriter.writeLineup(new Lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.DEFEND, Enums.site.A, Enums.projectile.MOLLY, Enums.throwType.THROW, Enums.land.GREEN_BOX, "viper8.jpg"));
      fileWriter.writeLineup(new Lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.ATTACK, Enums.site.B, Enums.projectile.MOLLY, Enums.throwType.THROW, Enums.land.DEFAULT, "viper9.jpg"));
      fileWriter.writeLineup(new Lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.ATTACK, Enums.site.B, Enums.projectile.SMOKE, Enums.throwType.JUMP_THROW, Enums.land.DEFAULT, "viper10.jpg"));
      fileWriter.writeLineup(new Lineup(Enums.agent.VIPER, Enums.map.ASCENT, Enums.side.DEFEND, Enums.site.B, Enums.projectile.ONE_WAY, Enums.throwType.THROW, Enums.land.LONG, "viper11.jpg"));*/
      
      //(agent agent, map map, side side, site site, projectile projectile, throwType throwType, land land, String imageID) 
      
      LineupFrame lineupFrame = new LineupFrame("Lineup App");
      lineupFrame.setSize(1024, 940);
      lineupFrame.setLocationRelativeTo(null);
      lineupFrame.setDefaultCloseOperation(LineupFrame.DISPOSE_ON_CLOSE);
      lineupFrame.setVisible(true);

      /*WriterFrame writerFrame = new WriterFrame("Lineup Writer");
      writerFrame.setSize(800, 150);
      writerFrame.setLocationRelativeTo(null);
      writerFrame.setDefaultCloseOperation(WriterFrame.DISPOSE_ON_CLOSE);
      writerFrame.setVisible(true);*/
      
      
   }

}
