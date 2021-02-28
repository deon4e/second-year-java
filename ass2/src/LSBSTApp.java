/**
 * LSBST's driver class
 * @author Deon Fourie
*/
import java.io.IOException;
public class LSBSTApp{
    /**
     * Main method that loads in file
     * @param args
     * @throws IOException
     */
    public static void main (String [] args) throws IOException{
        int length = args.length;
       // String fileName = args[3];
         String fileName = "../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
	 LSBST tree = new LSBST(fileName);
            if (length == 0) {
                tree.printAllAreas();
            }
            else if (length == 4 || length == 3){
                tree.printAreas(args[0], args[1], args[2]);
            }
            else {
                System.out.println("Arguments not valid");
         }
    }
}