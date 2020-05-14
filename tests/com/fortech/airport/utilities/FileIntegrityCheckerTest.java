package com.fortech.airport.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileIntegrityCheckerTest {

    @Test
    public void isFileValid_trueIfFileIsValid() {
        FileIntegrityChecker checker = new FileIntegrityChecker();

        assertTrue(checker.isFileValid("AirportSimulation.txt"));
        assertFalse(checker.isFileValid("AirportSimulation2.txt"));
    }
}