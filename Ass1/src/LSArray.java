import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;

public class LSArray {
	/** Op count variable to count operations used for experiment */

    int opCount=1;

/** Load in the file and create an array*/

    public LSData[] fileIn() throws IOException {
        Scanner fileIn = new Scanner(new File("/home/deon/Ass1/data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
        LSData[] data = new LSData[2976];
        String line;
/** for loop to iterated through data set and to create objects*/
        for (int i = 0; i < data.length; i++) {
            line = fileIn.nextLine();
            String[] parts = line.split(" ");
            String value1 = parts[0];
            String value2 = parts[1];
            data[i] = new LSData();
            data[i].setValue1(value1);
            data[i].setValue2(value2); }
	writeToFile();
	return data;
    }
/** prints a list of all areas */
    public void printAllAreas() throws IOException {
        LSData[] data = fileIn();
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i].getValue2().replace("-", ", "));
        }
	writeToFile();
    }

/** prints list of areas corresponding to the key */

    public void printAreas(String stage, String day, String time) throws IOException{
        String query = (stage + "_" + day + "_" +time);
        LSData[] data = fileIn();
        boolean found = false;
        for (int i = 0; i < data.length; i++) {
            opCount++;
            if (data[i].getValue1().contains(query)){
                opCount++;
		System.out.println(data[i].getValue2().replace("-", ", "));
                found =true;
		break;}
	writeToFile();
        }
        if (!found)
            System.out.println("Areas not found");
    }

    public int getOpCount(){
	return opCount;
	}
/** creates a file called opCount to show opCOunt value */    
    public void writeToFile() throws IOException{
	Writer wr = new FileWriter("/home/deon/Ass1/opCount.txt");
	wr.write( getOpCount() + "");
	wr.close();}
}
