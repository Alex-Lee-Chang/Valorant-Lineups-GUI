package lineup;
import java.util.PriorityQueue;

public class LineupTree implements Enums
{
   private int size;
   private agent agent;
   private LineupNode root;
   private FileUtility fileUtil;
   private PriorityQueue<Lineup> lineupQueue;

   public LineupTree(agent agent)
   {
      clear();
      this.agent = agent;

   }

   public void init()
   {
      map map;
      LineupNode root;
      
      Lineup lineup = new Lineup(agent, null, null, null);
      addChild(null, lineup);
      this.root = find(lineup);

      for (int i = 0; i < 5; ++i)
      {
         map = Enums.map.values()[i];
         lineup = new Lineup(agent, map, null, null);
         root = addChild(this.root, lineup);
         createMapFolders(agent, map, root);
      }
      
      
   }
   
   public void populateFolders() 
   {
      fileUtil = new FileUtility(agent);
      lineupQueue = fileUtil.readFile();
      if(lineupQueue != null) 
      {
         addQueue(lineupQueue);
      }
   }

   private void createMapFolders(agent agent, map map, LineupNode root)//there's probably a better way
   {
      LineupNode rootA = addChild(root, new Lineup(agent, map, Enums.side.ATTACK, null));
      LineupNode rootD = addChild(root, new Lineup(agent, map, Enums.side.DEFEND, null));
      
      addChild(rootA, new Lineup(agent, map, Enums.side.ATTACK, Enums.site.A));
      addChild(rootD, new Lineup(agent, map, Enums.side.DEFEND, Enums.site.A));
      
      addChild(rootA, new Lineup(agent, map, Enums.side.ATTACK, Enums.site.B));
      addChild(rootD, new Lineup(agent, map, Enums.side.DEFEND, Enums.site.B));
      
      if(map == Enums.map.HAVEN) 
      {
         addChild(rootA, new Lineup(agent, map, Enums.side.ATTACK, Enums.site.C));
         addChild(rootD, new Lineup(agent, map, Enums.side.DEFEND, Enums.site.C));
         addChild(rootA, new Lineup(agent, map, Enums.side.ATTACK, Enums.site.GARAGE));
         addChild(rootD, new Lineup(agent, map, Enums.side.DEFEND, Enums.site.GARAGE));
      }
      
      if(map == Enums.map.BIND) 
      {
         return;
      }
      
      addChild(rootA, new Lineup(agent, map, Enums.side.ATTACK, Enums.site.MID));
      addChild(rootD, new Lineup(agent, map, Enums.side.DEFEND, Enums.site.MID));
      
      
   }

   public LineupNode find(Lineup x)
   {
      return find(root, x, 0);
   }

   public LineupNode find(LineupNode root, Lineup x, int level)
   {
      LineupNode retval;

      if (size == 0 || root == null)
         return null;

      if (root.data.equals(x))
         return root;

      if (level > 0 && (retval = find(root.sib, x, level)) != null)
         return retval;
      return find(root.child, x, level + 1);
   }

   public void addQueue(PriorityQueue<Lineup> lineupQueue)
   {
      Lineup lineupIn;
      LineupNode root;
      while(!lineupQueue.isEmpty()) 
      {
         lineupIn = lineupQueue.remove();
         root = find(new Lineup(lineupIn.getAgent(), lineupIn.getMap(), lineupIn.getSide(), lineupIn.getSite()));
         addChild(root, lineupIn);
      }
   }

   public LineupNode addChild(LineupNode treeNode, Lineup x)
   {
      if (size == 0)
      {
         if (treeNode != null)
            return null;
         root = new LineupNode(x, null, null, null);
         root.topRoot = root;
         size = 1;
         return root;
      }

      if (treeNode == null)
         return null;
      if (treeNode.topRoot != root)
         return null;

      LineupNode newNode = new LineupNode(x, treeNode.child, null, treeNode, root);
      treeNode.child = newNode;
      if (newNode.sib != null)
         newNode.sib.prev = newNode;
      ++size;
      return newNode;
   }

   public void remove(Lineup x)
   {
      remove(root, x);
   }

   public boolean remove(LineupNode root, Lineup x)
   {
      LineupNode node = null;

      if (size == 0 || root == null)
         return false;

      if ((node = find(root, x, 0)) != null)
      {
         removeNode(node);
         --size;
         return true;
      }
      return false;
   }

   public void removeNode(LineupNode nodeToDelete)
   {
      if (nodeToDelete == null || root == null || nodeToDelete.topRoot != root)
         return;

      while (nodeToDelete.child != null)
      {
         removeNode(nodeToDelete.child);
      }

      if (nodeToDelete.prev == null)
      {
         root = null;
      } else if (nodeToDelete.prev.sib == nodeToDelete)
      {
         nodeToDelete.prev.sib = nodeToDelete.sib;
      } else
      {
         nodeToDelete.prev.child = nodeToDelete.sib;
      }

      if (nodeToDelete.sib != null)
         nodeToDelete.sib.prev = nodeToDelete.prev;
   }

   public <E extends Traverser<Lineup>> void traverse(E func, LineupNode treeNode, int level)
   {
      if (treeNode == null)
         return;

      func.visitStep(treeNode.data);

      traverse(func, treeNode.child, level + 1);
      if (level > 0)
      {
         traverse(func, treeNode.sib, level);
      }
   }

   public void display() { display(root, 0); }
   public void display(LineupNode node, int level)
   {

      if (node == null || level < 0)
      {
         return;
      }

      for (int i = level; i > 0; --i)
      {
         System.out.print(" ");
      }

      System.out.println(node.data);

      display(node.child, level + 1);
      if (level > 0)
      {
         display(node.sib, level);
      }

   }

   public void clear()
   {
      size = 0;
      root = null;
   }
}
