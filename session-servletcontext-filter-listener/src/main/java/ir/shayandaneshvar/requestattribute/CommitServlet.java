package ir.shayandaneshvar.requestattribute;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/CommitServlet")
public class CommitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {

        Map<String, String> errors = new HashMap<>();
        Map<String, String> after = new HashMap<>();

        String inputName = request.getParameter("inputName");
        String inputGender = request.getParameter("gender");

        after.put("inputName", inputName);

        if (!validateName(inputName))
            errors.put("Name", "Please enter a valid name");
        if (inputGender == null)
            errors.put("Gender", "Please select a Gender");
        if (errors.isEmpty())
            response.sendRedirect("index.jsp");
        else {
            request.setAttribute("after", after); // request scope
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("commit.jsp").forward(request, response);
        }
    }

    public static boolean validateName(String txt)
    {
        String regex = "^[a-z]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.matches();
    }
}

