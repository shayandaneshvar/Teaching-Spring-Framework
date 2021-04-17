package com.example.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Registration", value = "/Registration")
public class RegistrationWithCookie extends HttpServlet {
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

        if (lastName == null || firstName == null || lastName.length() == 0 || firstName.length() == 0){
            out.println("Last Name and First Name are required");
        } else{
            // Create cookies and send cookies to browsers
            Cookie cookieLastName = new Cookie("lastName", lastName);
            // cookieLastName.setMaxAge(1000);
            response.addCookie(cookieLastName);
            Cookie cookieFirstName = new Cookie("firstName", firstName);
            response.addCookie(cookieFirstName);
            // cookieFirstName.setMaxAge(0);
            Cookie cookieMi = new Cookie("mi", mi);
            response.addCookie(cookieMi);
            Cookie cookieTelephone = new Cookie("telephone", telephone);
            response.addCookie(cookieTelephone);
            Cookie cookieEmail = new Cookie("email", email);
            response.addCookie(cookieEmail);
            Cookie cookieStreet = new Cookie("street", street);
            response.addCookie(cookieStreet);
            Cookie cookieCity = new Cookie("city", city);
            response.addCookie(cookieCity);
            Cookie cookieState = new Cookie("state", state);
            response.addCookie(cookieState);
            Cookie cookieZip = new Cookie("zip", zip);
            response.addCookie(cookieZip);

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
        String lastName = "";
        String firstName = "";
        String mi = "";
        String telephone = "";
        String email = "";
        String street = "";
        String city = "";
        String state = "";
        String zip = "";

        // Read the cookies
        Cookie[] cookies = request.getCookies();

        // Get cookie values
        for (Cookie cookie : cookies) {
            switch (cookie.getName()) {
                case "lastName":
                    lastName = cookie.getValue();
                    break;
                case "firstName":
                    firstName = cookie.getValue();
                    break;
                case "mi":
                    mi = cookie.getValue();
                    break;
                case "telephone":
                    telephone = cookie.getValue();
                    break;
                case "email":
                    email = cookie.getValue();
                    break;
                case "street":
                    street = cookie.getValue();
                    break;
                case "city":
                    city = cookie.getValue();
                    break;
                case "state":
                    state = cookie.getValue();
                    break;
                case "zip":
                    zip = cookie.getValue();
                    break;
                default:
                    break;
            }
        }
        try {
            storeStudent(lastName, firstName, mi, telephone, email, street, city, state, zip);
            Cookie cookieLastName = new Cookie("lastName", lastName);
            response.addCookie(cookieLastName);
            out.println(firstName + " " + lastName +
                    " is now registered in the database");
            out.close(); // Close stream
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        }
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
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/javabook", "root", "123456");
            System.out.println("Database connected");

            // Create a Statement
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
