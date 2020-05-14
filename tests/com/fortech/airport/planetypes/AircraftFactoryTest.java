package com.fortech.airport.planetypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AircraftFactoryTest {

    @Test
    public void newAircraft_typeHelicopterNewHelicopter() {
        Flyable expectedFlyable = AircraftFactory.newAircraft("Helicopter", "H1", 10, 10, 10);

        boolean isInstanceOfHelicopter = expectedFlyable instanceof Helicopter;

        assertTrue(isInstanceOfHelicopter);
    }

    @Test
    public void newAircraft_typeBaloonNewBalloon() {
        Flyable expectedFlyable = AircraftFactory.newAircraft("BaLooN", "B1", 10, 10, 10);

        boolean isInstanceOfBaloon = expectedFlyable instanceof Baloon;

        assertTrue(isInstanceOfBaloon);
    }

    @Test
    public void newAircraft_TypeJetPlaneNewJetPlane() {
        Flyable expectedFlyable = AircraftFactory.newAircraft("jetPlane", "j1", 10, 10, 10);

        boolean isInstanceOfJetPlane = expectedFlyable instanceof JetPlane;

        assertTrue(isInstanceOfJetPlane);
    }

    @Test
    public void newAircraft_otherType() {
        Flyable expectedFlyable = AircraftFactory.newAircraft("plane", "p1", 10, 10, 10);

        boolean isInstanceOfDefinedAircrafts = expectedFlyable instanceof JetPlane || expectedFlyable instanceof Helicopter || expectedFlyable instanceof Baloon;

        assertFalse(isInstanceOfDefinedAircrafts);
    }
}