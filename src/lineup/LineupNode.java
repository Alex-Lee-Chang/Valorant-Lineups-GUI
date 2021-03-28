package lineup;
public class LineupNode implements Enums
{
   protected LineupNode sib, prev, child, topRoot;
   
   protected Lineup data;
   
   public LineupNode() 
   {
      this(null, null, null, null);
   }
   public LineupNode(Lineup data, LineupNode sib, LineupNode child, LineupNode prev) 
   {
      this.data = data;
      this.sib = sib;
      this.child = child;
      this.prev = prev;
      this.topRoot = null;
   }
   protected LineupNode(Lineup data, LineupNode sib, LineupNode child, LineupNode prev, LineupNode topRoot) 
   {
      this(data, sib, child, prev);
      this.topRoot = topRoot;
   }
   
   public Lineup getData() { return data; }
   public LineupNode getSib() { return sib; }
   public LineupNode getPrev() { return prev; }
   public LineupNode getChild() { return child; }
   public LineupNode getTopRoot() { return topRoot; }
   
   public void setPrev(LineupNode node) { prev = node; }
}
