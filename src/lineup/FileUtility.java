package lineup;
import java.util.PriorityQueue;
import java.io.*;
import java.util.Scanner;

public class FileUtility implements Enums
{
   private PriorityQueue<Lineup> lineupQueue;
   private static String[] projectileArray = new String[projectile.values().length];
   private static String[] landArray = new String[land.values().length];
   private static String[] throwTypeArray = new String[throwType.values().length];
   private static boolean arraysSet = false;
   
   private static String mapAssist = "ABHIS";
   private static String siteAssist = "ABCMG";
   
   private boolean fileRead = false;
   
   FileWriter out;
   Scanner in;
   
   private String agentName;
   private agent agent;
   private String fileName;
   private File file;
   
   public FileUtility(agent name) 
   {
      setArrays();
      agent = name;
      agentName = agent.toString().toLowerCase();
      fileName = "lineupFiles/" + agentName + ".txt";
      file = new File(fileName);
   }
   
   private void setArrays() 
   {
      if(arraysSet)
         return;
      for(int i = 0; i < projectileArray.length; ++i) 
         projectileArray[i] = projectile.values()[i].name();
      
      for(int i = 0; i < landArray.length; ++i) 
         landArray[i] = land.values()[i].name();
      
      for(int i = 0; i < throwTypeArray.length; ++i) 
         throwTypeArray[i] = throwType.values()[i].name();
      
      arraysSet = true;
   }
   
   public PriorityQueue<Lineup> readFile()
   {
      if(fileRead)
         return lineupQueue;

      try
      {
         in = new Scanner(file);
      } 
      catch (FileNotFoundException e)
      {
         System.out.println("File Not Found: " + fileName);
         return null;
      }
      
      String data;
      lineupQueue = new PriorityQueue<Lineup>(new LineupComparator());
      
      while(in.hasNextLine()) 
      {
         data = in.nextLine();
         //System.out.println(data);
         lineupQueue.add(stringToLineup(data));
      }
      fileRead = true;
      return lineupQueue;
   }
   
   public void writeLineup(Lineup lineup) 
   {
      if(lineup == null || lineup.isFolder())
         return;
      
      String retString = "";
      retString += lineup.getMap().name().charAt(0);
      retString += lineup.getSide().name().charAt(0);
      retString += lineup.getSite().name().charAt(0);
      
      String holder;
      
      if((holder = getIndex(projectileArray, lineup.getProjectile().name())) == null) 
         return;
      else
         retString += holder;
      
      if((holder = getIndex(landArray, lineup.getLand().name())) == null) 
         return;
      else
         retString += holder;
      
      if((holder = getIndex(throwTypeArray, lineup.getThrowType().name())) == null) 
         return;
      else
         retString += holder;
      
      if((lineup.getSecondThrowType() == null))
      {
    	  retString += "NA";
      }
      else 
      {
    	  holder = getIndex(throwTypeArray, lineup.getSecondThrowType().name());
    	  retString += holder;
      }
      
      retString += lineup.getImage();
    	  
      
      try 
      {
         out = new FileWriter(file, true);
         out.write(retString);
         out.write("\n");
         out.close();
      }
      catch(IOException e) 
      {
         return;
      }
      
      
   }
   
   private Lineup stringToLineup(String inString) 
   {
      map map;
      side side;
      site site;
      projectile projectile;
      land land;
      throwType throwType;
      throwType secondThrowType;
      String imageID;
      
      String temp;
      int index;
      
      temp = inString.substring(0, 1);
      index = mapAssist.indexOf(temp);
      map = Enums.map.values()[index]; 
      
      temp = inString.substring(1, 2);
      if(temp.equals("A")) 
         side = Enums.side.ATTACK;
      else 
         side = Enums.side.DEFEND;
      
      temp = inString.substring(2, 3);
      index = siteAssist.indexOf(temp);
      site = Enums.site.values()[index];
      
      temp = inString.substring(3, 5);
      index = Integer.parseInt(temp);
      projectile = Enums.projectile.values()[index];
      
      temp = inString.substring(5, 7);
      index = Integer.parseInt(temp);
      land = Enums.land.values()[index];
      
      temp = inString.substring(7, 9);
      index = Integer.parseInt(temp);
      throwType = Enums.throwType.values()[index];
      
      temp = inString.substring(9, 11);
      if(temp.equals("NA")) 
      {
    	  secondThrowType = null;
      }  
      else 
      {
    	  index = Integer.parseInt(temp);
          secondThrowType = Enums.throwType.values()[index];
      }
      
      
      imageID = inString.substring(11);
      
      
      return new Lineup(agent, map, side, site, projectile, throwType, secondThrowType, land, imageID);
   }
   
   private String getIndex(String[] array, String string) 
   {
      for(int i = 0; i < array.length; ++i) 
      {
         if(array[i].equals(string)) 
         {
            if(i < 9) 
            {
               return "0" + i;
            }
            return "" + i;
         }
      }
      return null;
   }
   
   public PriorityQueue<Lineup> getQueue(){ return lineupQueue; }
   
}
