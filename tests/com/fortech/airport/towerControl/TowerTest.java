package com.fortech.airport.towerControl;

import com.fortech.airport.planetypes.AircraftFactory;
import com.fortech.airport.planetypes.Coordinates;
import com.fortech.airport.planetypes.Helicopter;
import com.fortech.airport.planetypes.JetPlane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {

    @Test
    void register_hasNewObserver() {
        Tower tower = new Tower();
        Helicopter helicopter = (Helicopter) AircraftFactory.newAircraft("helicopter", "H1", 10, 11, 12);

        tower.register(helicopter);

        assertEquals(1, tower.getObservers().size());
        assertTrue(tower.getObservers().contains(helicopter));

    }

    @Test
    void unregister_eliminateOneObserver() {
        Tower tower = new Tower();
        Helicopter helicopter = (Helicopter) AircraftFactory.newAircraft("helicopter", "H1", 10, 11, 12);
        JetPlane jetPlane = (JetPlane) AircraftFactory.newAircraft("JetPlane", "j1", 14, 15, 16);

        tower.register(helicopter);
        tower.register(jetPlane);
        tower.unregister(helicopter);

        assertEquals(1, tower.getObservers().size());
        assertTrue(tower.getObservers().contains(jetPlane));
    }

    @Test
    void conditionsChanged_aircraftHasNewCoordinates() {
        WeatherTower weatherTower = new WeatherTower();
        Tower tower = new Tower();
        boolean areCoordinatesTheSame = true;
        Helicopter helicopter = (Helicopter) AircraftFactory.newAircraft("helicopter", "H1", 10, 11, 12);

        helicopter.registerTower(weatherTower);
        tower.register(helicopter);
        tower.conditionsChanged();
        areCoordinatesTheSame = helicopter.getCoordinates().getLongitude() == 10
                && helicopter.getCoordinates().getLatitude() == 11
                && helicopter.getCoordinates().getHeight() == 12;

        assertFalse(areCoordinatesTheSame);

    }
}