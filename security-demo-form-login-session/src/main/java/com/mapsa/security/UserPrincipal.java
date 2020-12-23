package com.mapsa.security;


import com.mapsa.model.User;
import lombok.Getter;

@Getter
public class UserPrincipal extends org.springframework.security.core.userdetails.User {
    private User user;

    public UserPrincipal(User user) {
        super(user.getName(), user.getPassword(), user.getRoles());
    }

}
