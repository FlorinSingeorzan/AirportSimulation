package com.fortech.airport.planetypes;

import com.fortech.airport.towerControl.WeatherTower;
import com.fortech.airport.utilities.OutputWriter;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String identity = this.getClass().getSimpleName() + name + "(" + id + ") ";
        switch (weatherTower.getWeather(coordinates)) {
            case SUN:
                super.updateCoordinates(10, 0, 2);
                OutputWriter.writeToFile(identity + "This is hot");
                break;
            case RAIN:
                super.updateCoordinates(5, 0, 0);
                OutputWriter.writeToFile(identity + "It s raining. Better watch out for lightings.");
                break;
            case SNOW:
                super.updateCoordinates(0, 0, -7);
                OutputWriter.writeToFile(identity + "OMG! Winter is coming!");
                break;
            case FOG:
                super.updateCoordinates(0, 1, 0);
                OutputWriter.writeToFile(identity + "I can see anything");

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
