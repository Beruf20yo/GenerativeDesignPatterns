package ru.example.singleton;

import java.time.LocalDateTime;

public class Logger {
    private static Logger logger = null;
    protected int num = 1;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println("[" + time + " " + (num++) + "] " + msg);
    }
}
