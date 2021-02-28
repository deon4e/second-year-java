// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   private int countInsert = 0;
   private int countFind = 0;
   /**
    * Height method to recursively determine node height
    * @param node
    * @return node height
    */
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   /**
    *
    * @param node
    * @return the difference of the ledt and right node height
    */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   /**
    * Method to fix the height
    * @param node
    */
    public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }

   /**
    * Method to rotate the AVl tree right
    * @param p
    * @return
    */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   /**
    * Method to rotate the AVl tree left
    * @param q
    * @return
    */

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }

   /**
    * Method to balance the tree
    * @param p
    * @return
    */

   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   /**
    * Method to change the datatype parameter to a node
    * @param d
    */

   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   /**
    * Method to insert a node into a tree
    * @param d
    * @param node
    * @return
    */
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
         countInsert++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   /**
    * Method to return the insert counter
    * @return
    */

   public int getCountInsert () {
      return countInsert;
   }
   /**
    * Method to change the deletion parameter from datatype
    * @param d
    */

   public void delete ( dataType d )
   {
      root = delete (d, root);
   }

   /**
    * Delete a node
    * @param d
    * @param node
    * @return
    */

   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   /**
    * Method to find the smallest node in the tree
    * @param node
    * @return
    */

   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }
   /**
    * Method to delete the minimum node
    * @param node
    * @return
    */

   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }
   /**
    * Method to chnage the find parameter from a given datatype to a node
    * @param d
    * @return
    */

   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /**
    * Method to find a matching node
    * @param d
    * @param node
    * @return
    */

   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      countFind++;
      if (d.compareTo (node.data) == 0)
         return node;
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   /**
    * Method to return the find operation counter variable
    * @return
    */

   public int getCountFind () {
      return countFind;
   }
   /**
    * Void method to order the tree
    *
    */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   /**
    * Method to order the tree
    * @param node
    * @param level
    */
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

