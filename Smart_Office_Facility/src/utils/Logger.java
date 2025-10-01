package src.utils;

import java.util.Date;

public class Logger {
    public static void log(String message) {
        System.out.println("[" + new Date().toString() + "] " + message);
    }
}