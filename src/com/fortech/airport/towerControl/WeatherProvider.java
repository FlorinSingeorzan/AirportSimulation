package com.fortech.airport.towerControl;

import com.fortech.airport.enumerations.WeatherType;
import com.fortech.airport.planetypes.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private final WeatherType[] weather;

    private WeatherProvider() {
        weather = WeatherType.values();
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public WeatherType getCurrentWhether(Coordinates coordinates) {
        Random random = new Random();
        int sum = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight() + random.nextInt(4);
        int index = sum % 4;
        return weather[index];
    }


}
