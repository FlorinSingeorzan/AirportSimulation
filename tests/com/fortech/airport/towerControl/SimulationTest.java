package com.fortech.airport.towerControl;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    @Test
    public void main_simulateAndGenerateFile() {
        Simulation.main(new String[]{"AirportSimulation.txt"});
        File outputFile = new File("simulation.txt");

        assertTrue(outputFile.exists());
    }
}