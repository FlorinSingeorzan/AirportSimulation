package com.fortech.airport.towerControl;

import com.fortech.airport.enumerations.WeatherType;
import com.fortech.airport.planetypes.Coordinates;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherTowerTest {

    @Test
    public void getWhether_generateWeatherType() {
        WeatherTower weatherTower = new WeatherTower();
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);

        WeatherType generatedWeather = weatherTower.getWeather(initialCoordinates);
        boolean isWeatherType = Arrays.asList(WeatherType.values()).contains(generatedWeather);

        assertTrue(isWeatherType);
    }


    @Test
    public void shouldSimulate_trueIfValidFile() {
        WeatherTower weatherTower = new WeatherTower();

        boolean validFile = weatherTower.shouldSimulate("AirportSimulation.txt");

        assertTrue(validFile);
    }

    @Test
    public void runSimulation_fileExists() {
        WeatherTower weatherTower = new WeatherTower();

        weatherTower.runSimulation();
        File outputFile = new File("simulation.txt");

        assertTrue(outputFile.exists());
    }
}