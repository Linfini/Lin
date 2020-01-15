package com.seasun.message.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static List<String> getRegexSubString(String regex, String str) {
        List<String> results = new ArrayList<String>();

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            results.add(m.group(1));
        }
        return results;
    }
}
