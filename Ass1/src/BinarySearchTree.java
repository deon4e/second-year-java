import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class BinarySearchTree {
   Tree tree;
   Scanner scanner;
   String line, areas, params, fileName;
   int countInsert, countFind;
/** Constructor to initiate all variables */
   public BinarySearchTree() {
      tree = new Tree();
      scanner = null;
      line = "";
      areas = "";
      params = "";
      fileName ="/home/deon/Ass1/data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
   }
/** Splits the dataset into strings and adds each key and value combo to tree*/

   public void add() throws IOException {
      while (scanner.hasNext()) {
         line = scanner.nextLine();
         String[] parts = line.split(" ");
         params = parts[0];
         areas = parts[1];
         tree.add(params, areas);
      }
   }
/**Reads in a file*/
   public void fileIn() throws IOException {
      scanner = new Scanner(new File(fileName));
   }

   public void write(Tree tree){
      tree.traverse(tree.root);

   }
/*Prints all areas in the dataset */
   public void printAllAreas() throws IOException {
      BinarySearchTree data = new BinarySearchTree();
      data.fileIn();
      data.add();
      data.write(data.tree); }
/*Prints matching value of query supplied by user, or not found message*/
   public void printAreas(String stage, String day, String time) throws IOException {
      String query = (stage + "_" + day + "_" + time);
      BinarySearchTree data = new BinarySearchTree();
      data.fileIn();
      data.add();
      data.tree.write(query);
   }
}




