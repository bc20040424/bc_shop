package com.ybc.utils;

import com.ybc.entity.enums.VerifyEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUtils {

    public static boolean verify(String regex, String value) {
        if (StringTools.isEmpty(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean verify(VerifyEnum regex, String value) {
        return verify(regex.getRegex(), value);
    }
}
