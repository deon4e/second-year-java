import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Tree
{
    int countInsert, countFind;
    Node root;
    public Tree() {
        root = null;
        countInsert =0;
        countFind = 0; }
/** insert recursion */
    public Node insert(String key, String params, Node node) throws IOException
    {   countInsert++;

        if (node == null)
        {
            return new Node(key, params, null, null);
        }
        else if (key.compareTo(node.key) < 0)
        { node.left = insert(key, params, node.left);
            return node;
        }
        else {
            node.right = insert(key, params, node.right);

            return node;
        }

    }
/** find recursion */
    public String find(String query, Node node) {
        countFind++;
        if (node == null) {
            countFind++;
            System.out.print("Areas Not found");
        } else if (node.key.equals(query)) {
            System.out.print(node.getAreas().replace("-", ", "));
            countFind++;
        } else if (query.compareTo(node.key) < 0) {
            countFind++;
            return find(query, node.left);
        } else {
            countFind++;
            return find(query, node.right);
        }
        return null;
    }

    public void traverse(Node node)
    {
        if (node != null)
        {
            traverse(node.getLeft());
            System.out.println(node.getAreas().replace("-", ", "));
            traverse(node.getRight());
        }
    }


    public String write(String query)
    {
        return find(query, root);
    }

    public void add(String key, String params) throws IOException
    {
        root = insert(key, params, root);
    }
/** get and set methods*/
    public int getCountInsert(){
        return countInsert;
    }

    public int getCountFind() {
        return countFind;
    }

    public void setCountFind(int countFind) {
        this.countFind = countFind;
    }

    public void setCountInsert(int countInsert){
        this.countInsert = countInsert;
    }

    public void writeToFileFind() throws IOException {
        Writer wr = new FileWriter("countFind.txt");
        wr.write(getCountFind() + "");
        wr.close();
    }

    public void writeToFileInsert() throws IOException {
        Writer wr = new FileWriter("countInsert.txt");
        wr.write(getCountInsert() + "");
        wr.close();

    }
}

