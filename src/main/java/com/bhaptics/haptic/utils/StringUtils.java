package com.bhaptics.haptic.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StringUtils {
    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {

            LogUtils.logError("encodeValue() failed " + e.getMessage(), e);
        }

        return "";
    }

    public static String readFile(File file) {
        StringBuilder fileContents = new StringBuilder((int)file.length());

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            return fileContents.toString();
        } catch (FileNotFoundException e) {

            LogUtils.logError("not found", e);
        }

        return "";

    }
}
