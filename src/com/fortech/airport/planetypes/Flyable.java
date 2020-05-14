package com.fortech.airport.planetypes;

import com.fortech.airport.towerControl.WeatherTower;

public interface Flyable {

    public void updateConditions();

    public void registerTower(WeatherTower whetherTower);

}
