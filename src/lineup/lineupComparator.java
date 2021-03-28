package lineup;
import java.util.Comparator;

class LineupComparator implements Comparator<Lineup>, Enums
{
   public int compare(Lineup l1, Lineup l2) 
   {
      if(l1.getProjectile().compareTo(l2.getProjectile()) != 0) 
      {
         return l2.getProjectile().compareTo(l1.getProjectile());
      }
      return l2.getLand().compareTo(l1.getLand());
   }
}
