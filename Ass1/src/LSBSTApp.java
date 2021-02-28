import java.io.IOException;

public class LSBSTApp{
    public static void main(String [] args) throws IOException {
        if (args.length == 3)
            (new BinarySearchTree()).printAreas(args[0], args[1], args[2]);
        else
            (new BinarySearchTree()).printAllAreas();
        }
}

  



