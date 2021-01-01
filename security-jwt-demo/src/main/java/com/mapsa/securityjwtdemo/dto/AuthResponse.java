package com.mapsa.securityjwtdemo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AuthResponse {
    private String username;
    private String token;
//    private String expires_in;
}
