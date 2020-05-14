package com.fortech.airport.planetypes;

import com.fortech.airport.towerControl.WeatherTower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JetPlaneTest {


    @Test
    public void updateConditions_conditionsChanged() {
        WeatherTower weatherTower = new WeatherTower();
        boolean areCoordinatesTheSame = true;
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        JetPlane jetPlane = new JetPlane("JetPlane", initialCoordinates);

        jetPlane.registerTower(weatherTower);
        jetPlane.updateConditions();
        areCoordinatesTheSame = jetPlane.getCoordinates().getLongitude() == initialCoordinates.getLongitude() && jetPlane.getCoordinates().getLatitude() == initialCoordinates.getLatitude() && jetPlane.getCoordinates().getHeight() == initialCoordinates.getHeight();

        assertFalse(areCoordinatesTheSame);
    }


    @Test
    public void registerTower_throwsExceptionWhenNotRegistered() {
        WeatherTower weatherTower = new WeatherTower();
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        JetPlane jetPlane = new JetPlane("JetPlane", initialCoordinates);

        assertThrows(NullPointerException.class, jetPlane::updateConditions);
        assertDoesNotThrow(() -> {
            jetPlane.registerTower(weatherTower);
            jetPlane.updateConditions();
        });
    }

}