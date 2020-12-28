package ru.job4j.chapter005.lsp.parking;

import java.util.List;

public class PassengerCar implements Car {
    private Integer counrPlacePark;

    public PassengerCar(Integer counrPlacePark) {
        this.counrPlacePark = counrPlacePark;
    }

    @Override
    public List<Place> getCountPlace() {
        return null;
    }
}
