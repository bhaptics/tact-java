package com.bhaptics.haptic.utils;

public class LogUtils {
    public static void logError(String str, Exception e) {
        System.err.println(str + e.getMessage() + " " + e);
    }

    public static void log(String str) {
//        System.out.println(str);
    }
    public static void trace(String str) {
//        System.out.println(str);
    }
}
