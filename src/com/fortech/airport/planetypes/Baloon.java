package com.fortech.airport.planetypes;

import com.fortech.airport.towerControl.WeatherTower;
import com.fortech.airport.utilities.OutputWriter;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String identity = this.getClass().getSimpleName() + name + "(" + id + ") ";
        switch (weatherTower.getWeather(coordinates)) {
            case SUN:
                super.updateCoordinates(2, 0, 4);
                OutputWriter.writeToFile(identity + "Let s enjoy the good weather and take some pics.");
                break;
            case RAIN:
                super.updateCoordinates(0, 0, -5);
                OutputWriter.writeToFile(identity + "Damn you rain! You messed up my baloon.");
                break;
            case SNOW:
                super.updateCoordinates(0, 0, -15);
                OutputWriter.writeToFile(identity + "It s snowing. We re gonna crash.");
                break;
            case FOG:
                super.updateCoordinates(0, 0, 3);
                OutputWriter.writeToFile(identity + "I can see my propellers");
                break;
            default:
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
