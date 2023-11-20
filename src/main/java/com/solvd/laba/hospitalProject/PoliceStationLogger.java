package com.solvd.laba.hospitalProject;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class PoliceStationLogger {
    private static final Logger logger = Logger.getLogger("PoliceLog"); //create a logger

    static {
        try {
            FileHandler fileHandler = new FileHandler("policeStation.log");//will right log messages to "policeStation.log"
            fileHandler.setFormatter(new SimpleFormatter()); //format the log message
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        logger.info(message);
    }
}
