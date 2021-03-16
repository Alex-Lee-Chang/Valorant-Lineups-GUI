package lineup;
import java.util.Comparator;

class lineupComparator implements Comparator<lineup>, Enums
{
   public int compare(lineup l1, lineup l2) 
   {
      if(l1.getProjectile().compareTo(l2.getProjectile()) != 0) 
      {
         return l1.getProjectile().compareTo(l2.getProjectile());
      }
      return l1.getLand().compareTo(l2.getLand());
   }
}
