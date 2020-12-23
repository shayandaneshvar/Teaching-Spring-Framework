package com.mapsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@EnableJdbcHttpSession
@SpringBootApplication
public class SecurityDemoFormLoginSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoFormLoginSessionApplication.class, args);
    }

}
