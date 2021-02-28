import java.io.IOException;

/**
* Main class for AVL tree including printvalue and printAllvalue as per assignment 
* @author Deon Fourie
*/
public class LSAVLT {
    private AVLTree<LSData> tree;
    private FileIn file_in;
    /**
     * Construtor to initialize variables and the tree
     * @param file
     * @throws IOException
     */
    public LSAVLT(String file) throws IOException{
        tree = new AVLTree<LSData>();
        file_in = new FileIn( file );
        this.add();
    }
    /**
     * Method to insert the next line of the file into the tree
     */
    private void add() {
        while(file_in.hasNextLine()){
            tree.insert(file_in.readLine());
        }
    }
    /**
     * Search method to find the query in the tree
     * @param other
     * @return the data of the query or null
     */
    public LSData search ( LSData query ) {
        BinaryTreeNode<LSData> result  = tree.find(query);
        if (result == null){
            return null;
        }
        else return result.data;
    }
    /**
     * Method to change the paramter type from a string to a LSData object
     * @param key will be stage_day_time
     * @return
     */
    public LSData search(String key) {
        return this.search(new LSData(key));
    }
    /**
     * Method to print a list of areas for a given query
     * @param stage as a number from 1-8
     * @param day as a number corresponding to a day of the month
     * @param time start time of a load shedding period
     * @return
     */
    public String printAreas(String stage , String day , String time) {
        String query =  (stage+"_"+day+"_"+time);
        LSData data = this.search(query);
        if (data == null){
            System.out.println("Areas not found \nInsert counter: "+ tree.getCountInsert() + "\nSearch counter: "+ tree.getCountFind());
        }
        else
        System.out.println(data + "\nInsert counter: " + tree.getCountInsert() + "\nSearch counter: " + tree.getCountFind());
        return null;
    }
    /**
     * Void method to do a inOrder traversal of the tree
     */
    public void printAllAreas() {
        tree.inOrder();
	System.out.println("\nInsert counter: " + tree.getCountInsert());
    }
}