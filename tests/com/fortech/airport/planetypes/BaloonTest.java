package com.fortech.airport.planetypes;

import com.fortech.airport.towerControl.WeatherTower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaloonTest {

    @Test
    public void updateConditions_conditionsChanged() {
        WeatherTower weatherTower = new WeatherTower();
        boolean areCoordinatesTheSame = true;
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        Baloon baloon = new Baloon("Baloon", initialCoordinates);

        baloon.registerTower(weatherTower);
        baloon.updateConditions();
        areCoordinatesTheSame = baloon.getCoordinates().getLongitude() == initialCoordinates.getLongitude()
                && baloon.getCoordinates().getLatitude() == initialCoordinates.getLatitude()
                && baloon.getCoordinates().getHeight() == initialCoordinates.getHeight();

        assertFalse(areCoordinatesTheSame);
    }

    @Test
    public void registerTower_throwsExceptionWhenNotRegistered() {
        WeatherTower weatherTower = new WeatherTower();
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        Baloon baloon = new Baloon("Baloon", initialCoordinates);

        assertThrows(NullPointerException.class, baloon::updateConditions);
        assertDoesNotThrow(() -> {
            baloon.registerTower(weatherTower);
            baloon.updateConditions();
        });
    }
}