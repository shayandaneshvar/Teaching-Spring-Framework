package com.shayandaneshvar.cucumberdemo.util;

import com.shayandaneshvar.cucumberdemo.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MyUtil {
    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public void reverseUserText(User user) {
        String txt = user.getSomeText();
        user.setSomeText(reverse(txt));
    }
}
