package com.fortech.airport.planetypes;

import com.fortech.airport.towerControl.WeatherTower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelicopterTest {

    @Test
    public void updateConditions_conditionsChanged() {
        WeatherTower weatherTower = new WeatherTower();
        boolean areCoordinatesTheSame = true;
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        Helicopter helicopter = new Helicopter("Helicopter", initialCoordinates);

        helicopter.registerTower(weatherTower);
        helicopter.updateConditions();
        areCoordinatesTheSame = helicopter.getCoordinates().getLongitude() == initialCoordinates.getLongitude() && helicopter.getCoordinates().getLatitude() == initialCoordinates.getLatitude() && helicopter.getCoordinates().getHeight() == initialCoordinates.getHeight();

        assertFalse(areCoordinatesTheSame);
    }


    @Test
    public void registerTower_throwsExceptionWhenNotRegistered() {
        WeatherTower weatherTower = new WeatherTower();
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        Helicopter helicopter = new Helicopter("Helicopter", initialCoordinates);

        assertThrows(NullPointerException.class, helicopter::updateConditions);
        assertDoesNotThrow(() -> {
            helicopter.registerTower(weatherTower);
            helicopter.updateConditions();
        });
    }
}