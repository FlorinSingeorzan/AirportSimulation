package com.fortech.airport.towerControl;

import com.fortech.airport.planetypes.Flyable;
import com.fortech.airport.planetypes.Aircraft;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        ((Aircraft) flyable).setIsRegistered(flyable.getClass().getSimpleName(), true);
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        ((Aircraft) flyable).setIsRegistered(flyable.getClass().getSimpleName(), false);
    }

    void conditionsChanged() {
        observers.forEach(Flyable::updateConditions);
        List<Flyable> landedAircrafts = new ArrayList<>();
        observers.forEach(
                (flyable) -> {
                    if (((Aircraft) flyable).getCoordinates().getHeight() <= 0) {
                        landedAircrafts.add(flyable);
                    }
                });
        landedAircrafts.forEach(this::unregister);
    }

    public List<Flyable> getObservers() {
        return observers;
    }
}
