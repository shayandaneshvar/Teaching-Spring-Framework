package ir.shayandaneshvar.context;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet(value = "/context-demo", name = "ServletContextDemo")
public class ServletContextDemo extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletContext context = getServletContext();
        Enumeration<String> e = context.getInitParameterNames();
        while (e.hasMoreElements()) {
            String str = e.nextElement();
            out.print("<br> " + context.getInitParameter(str));
        }
        out.close();
    }
}
