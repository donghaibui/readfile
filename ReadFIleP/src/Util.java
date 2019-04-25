import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by house on 4/20/2019.
 */
public class Util {



    public static List<String> getAllLinesFromFile(String filePath) throws IOException {

        Path path= Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return lines;


    }

    public static String getStringBetween(String input,String start, String end){
        String result = null;
        String regexStart  = ".*" + start + ".*";
        String regexEnd  = ".*" + end + ".*";
        if(input.matches(regexStart)&&input.matches(regexEnd)){
            result = input.substring(input.indexOf(start)+start.length(),input.indexOf(end));
        }
        return result;
    }


    public static void exportTxt(String filePath,String s){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(out);
            byte b[] = s.getBytes();
            bufferedOutputStream.write(b);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

}


    public static ArrayList<String> readFile(String filePath,String start, String end) throws IOException {

        ArrayList<String> listResults = new ArrayList<String>();
        String result = null;


        FileReader in = new FileReader(filePath);
        BufferedReader br = new BufferedReader(in);
        String line = br.readLine();
        while (line != null) {

            result = getStringBetween(line,start,end);
            if(result != null)
                listResults.add(result);

            line = br.readLine();
        }

        in.close();
        return listResults;

    }


    public static List<ScriptParameters> readFile(String filePath) throws IOException {

        List<ScriptParameters> listScriptparameters = new ArrayList<ScriptParameters>();
        String nameStart ="<scriptparameter parametername = \"";
        String nameEnd = "\" parametertype = \"";;
        String typeStart = "parametertype = \"";
        String typeEnd = "\">";

        FileReader in = new FileReader(filePath);
        BufferedReader br = new BufferedReader(in);
        String line = br.readLine();
        while (line != null) {
            ScriptParameters scriptParameters = new ScriptParameters();
            scriptParameters.setName(getStringBetween(line,nameStart,nameEnd));
            scriptParameters.setType(getStringBetween(line,typeStart,typeEnd));
            if(scriptParameters.getName()!= null && scriptParameters.getType()!= null)
                listScriptparameters.add(scriptParameters);
            line = br.readLine();
        }
        in.close();
        return listScriptparameters;
    }
}