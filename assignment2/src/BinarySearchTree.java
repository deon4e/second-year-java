// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   private int countInsert = 0;
   private int countFind = 0;
   /**
    * Insert function to add a root node to the tree
    * @param d
    */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   /**
    * Insert function to add a node to the tree that already has a root node
    * @param d
    * @param node
    */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      countInsert++;
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   /**
    * Method to view the insert count variable
    * @return countInsert int
    */
   public int getCountInsert () {
      return countInsert;
   }
   /**
    * Find method to change the parameter type from a given datatype to a node type for the other find function
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
    * Find method to recursively search the tree for a datatype
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
    * Method to view the find counter variable
    * @return
    */
   public int getCountFind () {
      return countFind;
   }
   /**
    * Delete method to change the parameter type from a given datatype to a node type for the other delete function
    * @param d
    */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }
   /**
    * Method to remove a node from a tree
    * @param d
    * @param node
    * @return Deleted node
    */
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   /**
    * Method to find the minimum node
    * @param node
    * @return minimum node
    */
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }
   /**
    * Method to remove the minimum node
    * @param node
    * @return deleted node
    */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
}
