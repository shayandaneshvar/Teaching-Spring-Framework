package ir.shayandaneshvar.i18n_spring_core_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "ir.shayandaneshvar")
public class Config {


    @Bean(name = "mySQLConnection")
    public Connection getMySQLConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook", "root", "123456");
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

//    @Bean(name = "monogConnection")
//    public Connection getMongoConnection(){
//        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook", "root", "123456");
//        } catch (SQLException throwables) {
//            throw new RuntimeException(throwables);
//        }
//    }

    // @Primary - @Qualifier - @Scope
}
