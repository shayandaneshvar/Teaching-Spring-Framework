package ir.shayandaneshvar.i18n_spring_core_bean;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "HelpServlet", value = "/help")
public class HelpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        ResourceBundle resourceBundle = getResourceBundle(req);
        printWriter.println("<html><head><meta charset='UTF-8'></head><body dir='" + resourceBundle.getObject("dir") + "'>");
        printWriter.println("<header>" + resourceBundle.getObject("name") + "</header>");
        printWriter.println("<h2>" + resourceBundle.getObject("text") + "</h2>");
        printWriter.println("<footer>" + resourceBundle.getObject("info") + "</footer>");
        printWriter.println("</body></html>");
        printWriter.close();
    }

    private ResourceBundle getResourceBundle(HttpServletRequest req) {
        return ResourceBundle.getBundle("Help", extractLocaleFromRequest(req));
    }

    private Locale extractLocaleFromRequest(HttpServletRequest req) {
        String systemLang = req.getLocale().getLanguage();
        Enumeration<Locale> locales = req.getLocales();
        while (locales.hasMoreElements()) {
            Locale locale;
            if (!(locale = locales.nextElement()).getLanguage().equals(systemLang) &&
                    ThreadLocalRandom.current().nextBoolean()) {
                return locale;
            }
        }
        return req.getLocale();
    }
}
