import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Example {
    

    List<ScriptParameters> listscripts() throws IOException {
        return Util.readFile("C:\\Hai Document\\myinput.txt");
    }

    public static void main(String[] args) throws IOException {

        List<ScriptParameters> listScriptparameters = new ArrayList<ScriptParameters>();
        listScriptparameters = Util.readFile("C:\\Hai Document\\myinput.txt");
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("template.mustache");
        mustache.execute(new PrintWriter("C:\\Hai Document\\myoutput.txt"), new Example() ).flush();



    }
}