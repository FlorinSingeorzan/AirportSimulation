package com.fortech.airport.planetypes;

import com.fortech.airport.enumerations.AircraftType;
import com.fortech.airport.towerControl.WeatherTower;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates actualCoordinates = new Coordinates(longitude, latitude, height);

        if (type.equalsIgnoreCase(String.valueOf(AircraftType.JetPlane))) {
            return new JetPlane(name, actualCoordinates);

        } else if (type.equalsIgnoreCase(String.valueOf(AircraftType.Helicopter))) {
            return new Helicopter(name, actualCoordinates);

        } else if (type.equalsIgnoreCase(String.valueOf(AircraftType.Baloon))) {
            return new Baloon(name, actualCoordinates);
        }

        return new Flyable() {
            @Override
            public void updateConditions() {

            }

            @Override
            public void registerTower(WeatherTower whetherTower) {

            }
        };
    }
}
