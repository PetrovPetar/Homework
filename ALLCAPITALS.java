import java.io.*;
import java.util.ArrayList;

/**
 * Created by petar on 2016-03-02.
 */
public class ALLCAPITALS {
    public static void main(String[] args) {
        try(
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\petar\\Desktop\\new.txt"));

        )
        {
            String line;
            PrintWriter writer = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("C:\\Users\\petar\\Desktop\\new.txt")));
            while((line = reader.readLine()) != null){
                writer.write(line.toUpperCase()+ "\r\n");

            }
        }
        catch (IOException ex){
            System.out.println(ex.toString());
        }
    }
}
