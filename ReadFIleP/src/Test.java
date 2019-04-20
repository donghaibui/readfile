import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by house on 4/20/2019.
 */
public class Test {

    public static void main(String arg[]) throws IOException {

        ArrayList<ScriptParameters> listScriptparameters = new ArrayList<ScriptParameters>();
        Map<String,String> map = new HashMap<String,String>();
        listScriptparameters = Util.readFile("C:\\Hai Document\\myinput.txt");
        for(ScriptParameters script : listScriptparameters){
            map.put(script.getName(),script.getType());

        }
    }
}
