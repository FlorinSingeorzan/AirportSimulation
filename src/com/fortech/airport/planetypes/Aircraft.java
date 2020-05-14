package com.fortech.airport.planetypes;

import com.fortech.airport.utilities.OutputWriter;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private static synchronized long nextId() {
        return idCounter++;
    }

    protected void updateCoordinates(int longitude, int latitude, int height) {
        Coordinates newCoordinates;
        int newLongitude = coordinates.getLongitude() + longitude;
        int newLatitude = coordinates.getLatitude() + latitude;
        int newHeight = coordinates.getHeight() + height;
        newHeight = Math.min(newHeight, 100);
        newCoordinates = new Coordinates(newLongitude, newLatitude, newHeight);
        this.coordinates = newCoordinates;
        System.out.println("Condition changed for " + name + " New conditions are " + newCoordinates);
    }


    public void setIsRegistered(String type, boolean status) {
        String prefix = status ? " " : " un";
        String message = "Tower says: " +
                type +
                name +
                "(" + id + ")" +
                prefix +
                "registered to whether tower  ";
        System.out.println(message);
        OutputWriter.writeToFile(message);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
