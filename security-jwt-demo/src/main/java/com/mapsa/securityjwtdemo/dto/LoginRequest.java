package com.mapsa.securityjwtdemo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
@Accessors(chain = true)
public class LoginRequest {
    private String username;
    private String password;


    public UsernamePasswordAuthenticationToken getAuth() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
