import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by house on 4/20/2019.
 */
public class Util {


    public static String getStringBetween(String input,String start, String end){
        String result = null;
        String regexStart  = ".*" + start + ".*";
        String regexEnd  = ".*" + end + ".*";
        if(input.matches(regexStart)&&input.matches(regexEnd)){
            result = input.substring(input.indexOf(start)+start.length(),input.indexOf(end));
        }
        return result;
    }

    public static ArrayList<ScriptParameters> readFile(String filePath) throws IOException {
        ArrayList<ScriptParameters> listScriptparameters = new ArrayList<ScriptParameters>();
        String nameStart ="<scriptparameter parametername = \"";
        String nameEnd = "\" parametertype";;
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
