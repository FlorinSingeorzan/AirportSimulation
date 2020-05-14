package com.fortech.airport.towerControl;

import com.fortech.airport.enumerations.WeatherType;
import com.fortech.airport.planetypes.Coordinates;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherProviderTest {

    @Test
    public void getCurrentWhether_generateWeatherType() {
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        Coordinates initialCoordinates = new Coordinates(10, 10, 10);
        boolean isWeatherType = false;

        WeatherType generatedWeatherType = weatherProvider.getCurrentWhether(initialCoordinates);
        isWeatherType = Arrays.asList(WeatherType.values()).contains(generatedWeatherType);

        assertTrue(isWeatherType);
    }
}