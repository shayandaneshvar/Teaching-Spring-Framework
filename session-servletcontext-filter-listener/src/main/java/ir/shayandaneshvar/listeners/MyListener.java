package ir.shayandaneshvar.listeners;

import javax.servlet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebListener
public class MyListener implements ServletContextListener ,
        ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver loaded");

        // Establish a connection
        ServletContext ctx = event.getServletContext();
        String user = ctx.getInitParameter("dbusername");
        String pwd = ctx.getInitParameter("dbpassword");

        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/javabook", user, pwd);
            ctx.setAttribute("DatabaseConnection", conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Database connected");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }
}
