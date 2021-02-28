import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class handles all the files for both AVL and BST, just makes the LSBST and LSAVL classes less sloppy
 * @author Deon Fourie
*/
public class FileIn{
    private File file;
    private Scanner scanner;
    /**
     * FileIn constructor that initialiazes key and value objects
     * @param file
     * @throws IOException
     */
    public FileIn(String file) throws IOException{
        this.file = new File(file);
        this.scanner = new Scanner(this.file);
    }
    /**
     * Boolean to return a true or false value, i.e whether or not the file has a next line
     * @return
     */
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }
    /**
     * Method that splits the custom data file into key and value parameters
     * @return LSData object per line of the txt file
     */
    public LSData readLine(){
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        String key = parts[0];
        String value = parts[1];
        return new LSData(key, value);
    }
    /**
     * ToString method for a filename
     */
    public String toString(){
        return this.file.getName();
    }

}