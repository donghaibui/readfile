import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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


    public static Map<String,String> readFile(String filePath) throws IOException {

        Map<String,String> listScriptparameters = new HashMap<String,String>();
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
                listScriptparameters.put(scriptParameters.getName(),scriptParameters.getType());
            line = br.readLine();
        }
        in.close();
        return listScriptparameters;
    }
}