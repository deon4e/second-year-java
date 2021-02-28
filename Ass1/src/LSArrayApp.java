import java.io.IOException;

public class LSArrayApp {
    public static void main(String [] args) throws IOException {
        if (args.length == 3)
            (new LSArray()).printAreas(args[0], args[1], args[2]);
        else
            (new LSArray()).printAllAreas();
        }
}