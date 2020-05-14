package com.fortech.airport.utilities;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AirportLogger {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void log(String message) {
        LOGGER.log(Level.INFO, message);

    }

    public static void logError(String message) {
        LOGGER.log(Level.INFO, message);

    }
}
