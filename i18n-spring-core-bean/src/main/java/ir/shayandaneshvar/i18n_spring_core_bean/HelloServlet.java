package ir.shayandaneshvar.i18n_spring_core_bean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Locale defaultLocale = request.getLocale();
        Enumeration<Locale> locales = request.getLocales();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p> default locale: " + defaultLocale + "</p>");

        while (locales.hasMoreElements()) {
            out.println("<p> locale: " + locales.nextElement() + "</p>");
        }
        out.println("<hr/>");

        out.println("<p>" + request.getRemoteHost() + "</p>");
        out.println("<p>" + request.getHeader("X-FORWARDED-FOR") + "</p>");

        out.println("</body></html>");
        out.close();
    }

    public void destroy() {
    }
}
