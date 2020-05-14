package com.fortech.airport.towerControl;

import com.fortech.airport.enumerations.WeatherType;
import com.fortech.airport.planetypes.Coordinates;
import com.fortech.airport.utilities.FileIntegrityChecker;
import com.fortech.airport.utilities.OutputWriter;
import com.fortech.airport.utilities.SimulationFileReader;

import java.io.IOException;

public class WeatherTower extends Tower {

    int noOfSimulations;

    public WeatherTower() {
        OutputWriter.deleteFile();
    }

    public WeatherType getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWhether(coordinates);
    }

    private void changeWhether() {
        super.conditionsChanged();
    }

    public boolean shouldSimulate(String inputFile) {
        SimulationFileReader fileReader = new SimulationFileReader(inputFile);
        FileIntegrityChecker checker = new FileIntegrityChecker();
        if (!checker.isFileValid(inputFile)) {
            return false;
        }
        this.noOfSimulations = fileReader.readNoOfSimulations();
        fileReader.readAircrafts().forEach((aircraft) -> aircraft.registerTower(this));
        return true;
    }

    public void runSimulation() {
        for (int i = 0; i < noOfSimulations; i++) {
            changeWhether();
        }

    }

}
