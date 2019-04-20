import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by house on 4/20/2019.
 */
public class Util {

    public static void readFile(String filePath) throws IOException {
        FileReader in = new FileReader(filePath);
        BufferedReader br = new BufferedReader(in);


        while (br.readLine() != null) {

        }
        in.close();


    }
}
