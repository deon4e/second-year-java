public class Node
{
    public String key, areas;
    public Node left, right;

    public Node(String key, String areas, Node left, Node right)
    {
        this.key = key;
        this.areas = areas;
        this.left = left;
        this.right = right;
    }

    public String getKey()
    {
        return key;
    }

    public String getAreas()
    {
        return areas;
    }

    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }
}