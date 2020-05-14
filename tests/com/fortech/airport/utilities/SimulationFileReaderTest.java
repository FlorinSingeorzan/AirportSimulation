package com.fortech.airport.utilities;

import com.fortech.airport.planetypes.Flyable;
import com.fortech.airport.towerControl.Simulation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationFileReaderTest {
    SimulationFileReader reader;

    @BeforeEach
    public void createSimulationFileReader() {
        reader = new SimulationFileReader("AirportSimulation.txt");
    }


    @Test
    public void readAircrafts_createNonNullAircraftList() {
        List<Flyable> flyables = reader.readAircrafts();

        assertNotEquals(0, flyables.size());
    }

    @Test
    public void readNoOfSimulations_returnValidNumber() {
        int noOfSimulation = reader.readNoOfSimulations();

        assertNotEquals(-1, noOfSimulation);
    }
}