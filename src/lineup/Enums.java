package lineup;
public interface Enums
{
   enum agent {SOVA, VIPER, BRIMSTONE, KILLJOY, SAGE, CYPHER, PHOENIX, YORU, RAZE}
   enum map {ASCENT, BIND, HAVEN, ICEBOX, SPLIT}
   enum side {ATTACK, DEFEND}
   enum site {A, B, C, MID, GARAGE}
   enum projectile
   {
      MOLLY, SHOCK_DART, RECON_DART, SMOKE, ONE_WAY, SLOW, TELEPORT, GRENADE;

      public String toString()
      {
         if(this.name().contains("_")) 
         {
            return this.name().replace('_', ' ');
         }
         return this.name();
      }
   }
   enum throwType
   {
      JUMP_THROW, THROW, TAP_NO, TAP_ONE_, TAP_TWO, ONE_NO, ONE_ONE, ONE_TWO, TWO_NO, TWO_ONE, TWO_TWO, FULL_NO, FULL_ONE, FULL_TWO, TAP_NO_JUMP, ONE_NO_JUMP;

      public String toString()
      {
         switch (this)
         {
         case JUMP_THROW:
            return "JUMP THROW";
         case THROW:
            return this.name();
         }
         
         String name = this.name();
         String retString = "";
         
         switch(name.substring(0, 3)) 
         {
         case "TAP": 
            retString += "TAP";
            break;
         case "ONE":
            retString += "ONE BAR";
            break;
         case "TWO":
            retString += "TWO BARS";
            break;
         case "FUL":
            retString += "FULL CHARGE";
            break;
         }
         
         int index = name.indexOf("_");
         switch(name.substring(index+1)) 
         {
         case "NO":
            retString += " WITH NO BOUNCES";
            break;
         case "ONE":
            retString += " WITH ONE BOUNCE";
            break;
         case "TWO":
            retString += " WITH TWO BOUNCES";
            break;
         case "NO_JUMP":
            retString += " WITH NO BOUNCES AND A JUMP"; //TODO
            break;
         }
         return retString;
         
      }
   }

   enum land
   {
      DEFAULT, SECOND_DEFAULT, BACK_SITE, HEAVEN, SHORT, LONG, GREEN_BOX, SIDE_GENERATOR;

      public String toString()
      {
         if(this.name().contains("_")) 
         {
            return this.name().replace('_', ' ');
         }
         return this.name();
      }
   } // TODO
}
