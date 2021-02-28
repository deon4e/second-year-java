// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   /**
    * Contructor to initialize all the variables
    * @param d
    * @param l
    * @param r
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   /**
    * Get methods to return node value
    * @return left node
    */
   BinaryTreeNode<dataType> getLeft () { return left; }
   /**
    * Get methods to return node value
    * @return right node
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
