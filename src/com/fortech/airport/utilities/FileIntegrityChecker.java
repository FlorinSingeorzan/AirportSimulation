package com.fortech.airport.utilities;

import com.fortech.airport.enumerations.AircraftType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileIntegrityChecker {

    public boolean isFileValid(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String noSim = bufferedReader.readLine();
            if (isNotPositiveNumber(noSim)) return false;

            String participants = bufferedReader.readLine();
            while (participants != null) {
                if (isAircraftDataIncorrect(participants)) {
                    return false;
                }
                participants = bufferedReader.readLine();
            }
        } catch (Exception e) {
            AirportLogger.logError(e.getMessage());
            return false;
        }

        return true;
    }

    private boolean isNotPositiveNumber(String simNo) {
        try {
            int noOfSimulation = Integer.parseInt(simNo);
            return noOfSimulation <= 0;
        } catch (Exception e) {
            AirportLogger.logError(e.getMessage());
            return true;
        }
    }

    private boolean isAircraftDataIncorrect(String aircraftData) {
        String[] parts = aircraftData.split(" ");
        if (parts.length < 5) {
            return true;
        }
        AircraftType[] aircraftTypes = AircraftType.values();
        boolean incorrectType = Arrays.stream(aircraftTypes).noneMatch((el) -> parts[0].equalsIgnoreCase(el.name()));

        boolean invalidCoordinates = isNotPositiveNumber(parts[2]) || isNotPositiveNumber(parts[3]) || isNotPositiveNumber(parts[4]) || Integer.parseInt(parts[4]) > 100;
        return incorrectType || invalidCoordinates;
    }
}
