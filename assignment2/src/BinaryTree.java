// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   /**
    * Constructor to initialize the root node
    */
   public BinaryTree ()
   {
      root = null;
   }
   /**
    * Method to invoke get hoight method of a root
    * @return
    */
   public int getHeight ()
   {
      return getHeight (root);
   }
   /**
    * Method that recursively determines height of a tree
    * @param node
    * @return
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   /**
    * Method to call the getSize mehtod of a root
    * @return
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   /**
    * Returns the size of the node
    * @param node
    * @return
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   /**
    * Methdo to print the node's data
    * @param node
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   /**
    * Mehtod to call the preOrder method
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   /**
    * Method to carry out a preOrder traversal
    * @param node
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }
   }
   /**
    * Void method to call the postOrder method
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   /**
    * Method to carry out a post order traversal
    * @param node
    */
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }
   }
   /**
    * Void method to call the InOrder method
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   /**
    * Method to carry out an inOrder traversal
    * @param node
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }
   }
   /**
    * Method to level the order of the tree
    */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
