import java.io.IOException;
/**
 * Main Binary Search Tree class for Load Shedding data
 * @author Deon Fourie
 */
public class LSBST {
    private BinarySearchTree<LSData> tree;
    private FileIn file_in;
    /**
     * Constructor to initialize tree and the file coming in
     * @param file is a string of the filename
     * @throws IOException
     */
    public LSBST(String file) throws IOException {
        tree = new BinarySearchTree<LSData>();
        file_in = new FileIn(file);
        this.add();
    }
    /**
     * Void method to insert every next line into the tree
    */
    private void add() {
        while(file_in.hasNextLine()){
            tree.insert(file_in.readLine());
        }
    }
    /**
     * Search function to find the parameter in the tree
     * @param query stage_day_time as a LSData object
     * @return the data of the query or null
     */
    public LSData search(LSData query) {
        BinaryTreeNode<LSData> result  = tree.find(query);
        if (result == null){
            return null;
        }
        else{
            return result.data;
        }
    }
    /**
     * Search method to invoke other search method, changes parameter type from String to LS Data
     * @param key stage_day_time as a string
     * @return invocation of other search function
     */
    public LSData search(String key) {
        return this.search(new LSData(key));
    }
    /**
     * Method to print out a list of areas for a given query
     * @param stage expressed as a number from 1-8
     * @param day expressed as a number corresponding to the day of the month
     * @param time start time of the load shedding period
     * @return Printed statement of either areas or null
     */
    public String printAreas(String stage , String day , String time) {
        String query = (stage+"_"+day+"_"+time);
        LSData data = this.search(query);
        if (data == null){
            System.out.println("Areas not found + \nInsert counter: " + tree.getCountInsert() + "\nSearch counter: " + tree.getCountFind());
        }
        else
        System.out.println(data + "\nInsert counter: " + tree.getCountInsert() + "\nSearch counter: " + tree.getCountFind());
        return null;
    }
    /**
     * Void function to print all the data, i.e. just traversing the tree
     */
    public void printAllAreas() {
        tree.inOrder();
	System.out.println("\nInsert counter: " + tree.getCountInsert());
    }
}