import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by house on 4/20/2019.
 */
public class Util {

    public static ArrayList<ScriptParameters> readFile(String filePath) throws IOException {
        ArrayList<ScriptParameters> listScriptparameters = new ArrayList<ScriptParameters>();
        int start;
        int end;
        String nameStart ="<scriptparameter parametername = \"";
        String nameEnd = "\" parametertype";
        String regexName  = ".*scriptparameter parametername.*";
        String regexType  = ".*parametertype.*";
        String typeStart = "parametertype = \"";
        String typeEnd = "\">";
        String name ;
        String type;

        FileReader in = new FileReader(filePath);
        BufferedReader br = new BufferedReader(in);
        String line = br.readLine();


        while (line != null) {
            ScriptParameters scriptParameters = new ScriptParameters();
            if(line.matches(regexName)) {
                start = line.indexOf(nameStart) + nameStart.length();
                end = line.indexOf(nameEnd);
                name = line.substring(start,end);
                scriptParameters.setName(name);
            }
            if(line.matches(regexType)){
                start = line.indexOf(typeStart) + typeStart.length();
                end = line.indexOf(typeEnd);
                type = line.substring(start,end);
                scriptParameters.setType(type);
            }
            if(scriptParameters.getName()!=null && scriptParameters.getType()!=null)
                listScriptparameters.add(scriptParameters);

            line = br.readLine();
        }
        in.close();


        return listScriptparameters;
    }
}
