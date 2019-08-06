package com.tavisca.workshops.practiceHttpServer;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    private final static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void log(String message) {

        try {
            FileHandler fileHandler = new FileHandler("mylogfile.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, message);
            fileHandler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

