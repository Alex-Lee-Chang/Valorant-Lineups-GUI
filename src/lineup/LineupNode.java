package lineup;
public class LineupNode implements Enums
{
   protected LineupNode sib, prev, child, topRoot;
   
   protected lineup data;
   
   public LineupNode() 
   {
      this(null, null, null, null);
   }
   public LineupNode(lineup data, LineupNode sib, LineupNode child, LineupNode prev) 
   {
      this.data = data;
      this.sib = sib;
      this.child = child;
      this.prev = prev;
      this.topRoot = null;
   }
   protected LineupNode(lineup data, LineupNode sib, LineupNode child, LineupNode prev, LineupNode topRoot) 
   {
      this(data, sib, child, prev);
      this.topRoot = topRoot;
   }
   
   public lineup getData() { return data; }
   public LineupNode getSib() { return sib; }
   public LineupNode getprev() { return prev; }
   public LineupNode getChild() { return child; }
   public LineupNode getTopRoot() { return topRoot; }
}
