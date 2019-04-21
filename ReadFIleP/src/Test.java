import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.twitter.io.OutputStreamWriter;
import com.twitter.io.Writer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


/**
 * Created by house on 4/20/2019.
 */
public class Test {

    public static void main(String arg[]) throws IOException {

        Map<String,String> listScriptparameters = new HashMap<String,String>();
        listScriptparameters = Util.readFile("C:\\Hai Document\\myinput.txt");
        MustacheFactory mf = new DefaultMustacheFactory();

        java.io.Writer writer = new StringWriter();
        Mustache mustache = mf.compile("todo-section.mustache");
        mustache.execute((java.io.Writer) writer,listScriptparameters.get("java"));
        System.out.println(writer.toString());


         writer.close();









    }
}

