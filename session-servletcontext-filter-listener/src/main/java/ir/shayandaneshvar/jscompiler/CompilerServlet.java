package ir.shayandaneshvar.jscompiler;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

@WebServlet("/compile")
public class CompilerServlet extends HttpServlet {
    private ScriptEngineManager engineManager;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        LinkedList<String> results = new LinkedList<>();
        String code = req.getParameter("code");
        String[] codes = code.split("\n");
        for (int i = 0; i < codes.length; i++) {
            String string = codes[i];
            if (string.startsWith("print")) {
                if (string.endsWith(";")) {
                    string = string.substring(0, string.length() - 1);
                }
                string = string.substring(5);
                try {
                    results.add(engine.eval(string).toString());
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    engine.eval(string);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
            }
        }
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<div style='background: lightgray'>");
        results.forEach(z -> writer.print("<br>" + z));
        writer.print("</div>");
        writer.close();
    }

    @Override
    public void init() throws ServletException {

        engineManager = new ScriptEngineManager();
    }
}
