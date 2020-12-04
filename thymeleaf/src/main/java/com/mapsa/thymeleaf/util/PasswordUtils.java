package com.mapsa.thymeleaf.util;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtils {
    private PasswordUtils() {
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password,/*"xyz"BCrypt.gensalt(5)*/BCrypt.gensalt());
    }

    public static boolean checkPassword(String hash,String password){
        return BCrypt.checkpw(password,hash);
    }
}
