package com.mapsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
/**
 * @author S.Shayan Daneshvar
 * Topics Covered:
 * 1. AAA
 * 2.Spring Security
 * 3.Spring Session
 * 4.Form Based Login
 * 5. In memory and JDBC based Session handling
 * 6. Annotation Based Security (Pre & PostAuthorize)
 */
@EnableJdbcHttpSession
@SpringBootApplication
public class SecurityDemoFormLoginSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoFormLoginSessionApplication.class, args);
    }

}
