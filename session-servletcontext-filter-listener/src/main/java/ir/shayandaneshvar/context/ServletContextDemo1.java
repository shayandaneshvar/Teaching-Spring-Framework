package ir.shayandaneshvar.context;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet1", value = "/servlet1")
public class ServletContextDemo1 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletContext context = getServletContext();
        context.setAttribute("company", "Mapsa");
        out.println("ServletContextDemo 1 !");
        out.println("<a href='servlet2'>visit</a>");
        out.close();
    }
}

