package com.fortech.airport.utilities;

import java.io.*;

public class OutputWriter {

    private final static String outputFileName = "simulation.txt";

    public static void writeToFile(String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName, true));
            writer.write(message);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            AirportLogger.log("Can't write to file");
            AirportLogger.logError(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        File file = new File(outputFileName);
        boolean isFileDeleted = file.delete();
        if (!isFileDeleted) {
            AirportLogger.log("Can't delete file");
        }
    }
}
