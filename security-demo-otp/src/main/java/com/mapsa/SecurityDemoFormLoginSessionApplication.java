package com.mapsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
/**
 * @author S.Shayan Daneshvar
 * Topics Covered:
 * 1.Custom Login page
 * 2. OTP with GMAIL, [forgot password]
 * 3. UsernamePasswordAuthenticationFilter [Introduction to filters]
 */
@EnableJdbcHttpSession
@SpringBootApplication
public class SecurityDemoFormLoginSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoFormLoginSessionApplication.class, args);
    }

}
