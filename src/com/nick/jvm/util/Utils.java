package com.nick.jvm.util;

/**
 * Created by KangShuai on 2017/7/17.
 */
public class Utils {
    public static boolean isEmpty(String s) {
        if (s == null) {
            return true;
        } else {
            return s.length() == 0;
        }
    }
}
