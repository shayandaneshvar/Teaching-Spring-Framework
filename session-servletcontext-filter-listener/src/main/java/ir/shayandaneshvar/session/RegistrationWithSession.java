package ir.shayandaneshvar.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@WebServlet(name = "Registration", value = "/Registration")
public class RegistrationWithSession extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";
    private PreparedStatement pstmt;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain data from the form
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mi = request.getParameter("mi");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        if (lastName == null || firstName == null || lastName.length() == 0 || firstName.length() == 0) {
            out.println("Last Name and First Name are required");
        } else {
            Address address = new Address();
            address.setLastName(lastName);
            address.setFirstName(firstName);
            address.setMi(mi);
            address.setTelephone(telephone);
            address.setEmail(email);
            address.setStreet(street);
            address.setCity(city);
            address.setState(state);
            address.setZip(zip);

            // Get an HttpSession or create one if it does not exist
            HttpSession httpSession = request.getSession();

            // Store student object to the session
            httpSession.setAttribute("address", address); // Session Scoped Attribute

            // Ask for confirmation
            out.println("You entered the following data");
            out.println("<p>Last name: " + lastName);
            out.println("<br>First name: " + firstName);
            out.println("<br>MI: " + mi);
            out.println("<br>Telephone: " + telephone);
            out.println("<br>Email: " + email);
            out.println("<br>Street: " + street);
            out.println("<br>City: " + city);
            out.println("<br>State: " + state);
            out.println("<br>Zip: " + zip);

            // Set the action for processing the answers
            out.println("<p><form method=\"post\"");
            out.println("<p><input type=\"submit\" value=\"Confirm\" >");
            out.println("</form>");
        }
        out.close(); // Close stream
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        // Obtain the HttpSession
        HttpSession httpSession = request.getSession();
        // Get the Address object in the HttpSession
        Address address = (Address) (httpSession.getAttribute("address"));

        try {
            storeStudent(address);
            out.println(address.getFirstName() + " " + address.getLastName() +
                    " is now registered in the database");
            out.close(); // Close stream
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        }
    }

    private void storeStudent(Address address) throws SQLException {
        storeStudent(address.getLastName(), address.getFirstName(), address.getMi()
                , address.getTelephone(), address.getEmail(), address.getStreet(), address.getCity(),
                address.getState(), address.getZip());
    }

    private void storeStudent(String lastName, String firstName,
                              String mi, String telephone, String email, String street,
                              String city, String state, String zip) throws SQLException {
        pstmt.setString(1, lastName);
        pstmt.setString(2, firstName);
        pstmt.setString(3, mi);
        pstmt.setString(4, telephone);
        pstmt.setString(5, email);
        pstmt.setString(6, street);
        pstmt.setString(7, city);
        pstmt.setString(8, state);
        pstmt.setString(9, zip);
        pstmt.executeUpdate();
    }

    private void initializeJdbc() {
        try {

            // see MyListener
            // Load the JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver loaded");
//
//            // Establish a connection
//            ServletConfig config = getServletConfig();
//            String user = config.getInitParameter("dbusername");
//            String pwd = config.getInitParameter("dbpassword");
//
//            Connection conn = DriverManager.getConnection
//                    ("jdbc:mysql://localhost:3306/javabook", user, pwd);
//            System.out.println("Database connected");

            // Create a Statement
            Connection conn = (Connection) getServletContext().getAttribute("DatabaseConnection");
            pstmt = conn.prepareStatement("insert into Address(lastName," +
                    " firstName, mi, telephone, email, street, city, "
                    + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void init() {
        initializeJdbc();
    }
}
