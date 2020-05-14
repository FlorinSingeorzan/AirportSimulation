package com.fortech.airport.utilities;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class OutputWriterTest {

    @Test
    public void writeToFile_newFileIsCreated() {
        OutputWriter.writeToFile("test");

        File outputFile = new File("simulation.txt");

        assertTrue(outputFile.exists());
    }

    @Test
    public void deleteFile_fileIsRemoved() {
        OutputWriter.deleteFile();

        File outputFile = new File("simulation.txt");

        assertFalse(outputFile.exists());
    }
}