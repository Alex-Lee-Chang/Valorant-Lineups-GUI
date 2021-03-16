package lineup;

public class lineup implements Enums, Comparable<lineup>
{
   private boolean isFolder;
   
   private String imageID;
   
   private agent agent;
   private map map;
   private side side;
   private site site;
   private projectile projectile;
   private throwType throwType;
   private throwType secondThrowType;
   private land land;
   
   public lineup (agent agent, map map, side side, site site) 
   {
      set(agent, map, side, site);
   }
   
   public lineup (agent agent, map map, side side, site site, projectile projectile, throwType throwType, land land, String imageID) 
   {
      set(agent, map, side, site, projectile, throwType, land, imageID);
   }
   
   public lineup (agent agent, map map, side side, site site, projectile projectile, throwType throwType, throwType secondThrowType, land land, String imageID) 
   {
      set(agent, map, side, site, projectile, throwType, land, imageID);
      this.secondThrowType = secondThrowType;
   }
   
   public void set(agent agent, map map, side side, site site) 
   {
      this.agent = agent;
      this.map = map;
      this.side = side;
      this.site = site;
      isFolder = true;
   }
   
   public void set(agent agent, map map, side side, site site, projectile projectile, throwType throwType, land land, String imageID) 
   {
      set(agent, map, side, site);
      this.projectile = projectile;
      this.throwType = throwType;
      this.land = land;
      this.imageID = imageID;
      isFolder = false;
      this.secondThrowType = null;
   }
   
   public int compareTo (lineup lineup) 
   {
      if(this.projectile.compareTo(lineup.projectile) != 0) 
      {
         return this.projectile.compareTo(lineup.projectile);
      }
      return this.land.compareTo(lineup.land);
   }
   
   public boolean equals(lineup lineup) 
   {
      if(lineup == null)
         return false;
      return this.agent == lineup.agent && 
            this.map == lineup.map && 
            this.side == lineup.side && 
            this.site == lineup.site && 
            this.projectile == lineup.projectile && 
            this.throwType == lineup.throwType && 
            this.land == lineup.land && 
            this.isFolder == lineup.isFolder && 
            this.imageID == lineup.imageID &&
            this.secondThrowType == lineup.secondThrowType;
   }
   
   public String toString() 
   {
      return agent + " " + map + " " + side + " " + site + " " + projectile + " " + throwType + " " + secondThrowType + " " + land + " " + imageID;
   }
   
   public boolean isFolder() { return isFolder; }
   public agent getAgent() { return agent; }
   public map getMap() { return map; }
   public side getSide() { return side; }
   public site getSite() { return site; }
   public projectile getProjectile() { return projectile; }
   public throwType getThrowType() { return throwType; }
   public throwType getSecondThrowType() { return secondThrowType;} 
   public land getLand() { return land; }
   public String getImage() { return imageID; }
   
}
