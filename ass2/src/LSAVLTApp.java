/**
 * Driver class for the LSAVLT class
 * @author Deon Fourie
 */
import java.io.IOException;
 public class LSAVLTApp {
    /**
     * Main method for LSAVLT class
     * @param args
     * @throws IOException
     */
    public static void main ( String [] args ) throws IOException{
        int length = args.length;
       // String fileName = args[3];
         String fileName = "../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
	 LSAVLT tree = new LSAVLT( fileName );
        if ( length == 0 ) {
            tree.printAllAreas();
        }
        else if (length == 3 || length == 4){
            tree.printAreas(args[0], args[1], args[2]);
        }
        else {
            System.out.println("Invalid arguments to main function");
        }
   }
}