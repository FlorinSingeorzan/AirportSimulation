package com.fortech.airport.planetypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AircraftTest {

    @Test
    public void updateCoordinates_hasNewCoordinates() {
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        Aircraft aircraft = new Aircraft("AircraftName", initialCoordinates);

        aircraft.updateCoordinates(5, 8, -2);

        boolean areCoordinatesTheSame = aircraft.getCoordinates().getLongitude() == initialCoordinates.getLongitude()
                && aircraft.getCoordinates().getLatitude() == initialCoordinates.getLatitude()
                && aircraft.getCoordinates().getHeight() == initialCoordinates.getHeight();
        assertFalse(areCoordinatesTheSame);
    }

}