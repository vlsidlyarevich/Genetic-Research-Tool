package com.github.vlsidlyarevich.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public  class Utils {



    public static String getPatentID(String patent) {
        Pattern idPattern = Pattern.compile("(file=\"[A-z0-9]+)");
        Matcher idMatcher = idPattern.matcher(patent);

        if (idMatcher.find()) {
            String result = idMatcher.group(0);
            return result = result.substring(result.indexOf("\"") + 1, result.length());
        } else return "invalid patent id";

    }

    public static String getSeqID(String word) {

        return word.replaceAll("\\D+","");
    }

}
