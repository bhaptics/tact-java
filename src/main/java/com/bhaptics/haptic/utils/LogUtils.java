package com.bhaptics.haptic.utils;

public class LogUtils {
    public static boolean isEnable = false;


    public static void logError(String str, Exception e) {
        if (isEnable) {
            System.err.println(str + e.getMessage() + " " + e);
        }
    }

    public static void log(String str) {
        if (isEnable) {
            System.out.println(str);
        }
    }
    public static void trace(String str) {
        if (isEnable) {
            System.out.println(str);
        }
    }
}
