package display;

import lineup.*;
import lineup.Enums.*;

import javax.swing.*;


public class main
{

   public static void main(String[] args)
   {
      LineupFrame lineupFrame = new LineupFrame("Lineup App");
      lineupFrame.setSize(1024, 940);
      lineupFrame.setLocationRelativeTo(null);
      lineupFrame.setDefaultCloseOperation(LineupFrame.DISPOSE_ON_CLOSE);
      lineupFrame.setVisible(true);

      WriterFrame writerFrame = new WriterFrame("Lineup Writer");
      writerFrame.setSize(1024, 940);
      writerFrame.setLocationRelativeTo(null);
      writerFrame.setDefaultCloseOperation(WriterFrame.DISPOSE_ON_CLOSE);
      writerFrame.setVisible(true);
      
      
   }

}
