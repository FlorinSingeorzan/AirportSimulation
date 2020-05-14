package com.fortech.airport.towerControl;


import com.fortech.airport.utilities.AirportLogger;

public class Simulation {

    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        boolean isFileValid = weatherTower.shouldSimulate(args[0]);
        if (isFileValid) {
            weatherTower.runSimulation();
        } else {
            AirportLogger.log("File is invalid");
        }
    }

}
