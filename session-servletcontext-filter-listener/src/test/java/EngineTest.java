import org.junit.jupiter.api.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;

public class EngineTest {

    @Test
    public void testEngineJs() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        engine.eval("var x = 2" );
        engine.eval("var z = 3");
        System.out.print(engine.eval("x+z"));
    }

    @Test
    public void testEnginePhp() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension(".py");
        engine.eval("x = 2" );
        engine.eval("z = 3");
        System.out.print(engine.eval("x+z"));
    }
    @Test
    public void testString(){
        String str = "hello \n bye";
        String[] s = str.split("\n");
        System.out.println(Arrays.toString(s));
    }
}
