package com.fortech.airport.utilities;

import com.fortech.airport.planetypes.Flyable;
import com.fortech.airport.planetypes.AircraftFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimulationFileReader {

    private String filename;

    public SimulationFileReader(String filename) {
        this.filename = filename;
    }


    public List<Flyable> readAircrafts() {
        List<Flyable> aircrafts = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            bufferedReader.readLine();

            String participants = bufferedReader.readLine();
            while (participants != null) {
                String[] parts = participants.split(" ");
                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);
                Flyable flyable = AircraftFactory.newAircraft(parts[0], parts[1], longitude, latitude, height);
                aircrafts.add(flyable);
                participants = bufferedReader.readLine();
            }
        } catch (Exception e) {
            AirportLogger.log("Can't read File");
            e.printStackTrace();
        }
        return aircrafts;
    }

    public int readNoOfSimulations() {
        int noOfSimulations = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String noSim = bufferedReader.readLine();
            noOfSimulations = Integer.parseInt(noSim);

        } catch (IOException e) {
            AirportLogger.log("Can't read File");
            e.printStackTrace();
        }
        return noOfSimulations;
    }
}
