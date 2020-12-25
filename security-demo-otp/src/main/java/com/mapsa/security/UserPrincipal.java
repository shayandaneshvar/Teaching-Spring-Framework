package com.mapsa.security;


import com.mapsa.model.User;
import lombok.Getter;

@Getter
public class UserPrincipal extends org.springframework.security.core.userdetails.User {
    private User user;

    public UserPrincipal(User user) {
        super(user.getName(), extractPassword(user), user.getRoles());
    }

    private static String extractPassword(User user) {
        if (user.getOneTimePassword() != null) {
            if (user.getOneTimePassword().hasExpired()) {
                return "";
            }
            return user.getOneTimePassword().getContent();
        }
        return user.getPassword();
    }

}
