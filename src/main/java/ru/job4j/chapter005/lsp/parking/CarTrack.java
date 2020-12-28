package ru.job4j.chapter005.lsp.parking;

import java.util.List;

public class CarTrack implements Car {
    private Integer counrPlacePark;

    public CarTrack(Integer counrPlacePark) {
        this.counrPlacePark = counrPlacePark;
    }

    @Override
    public List<Place> getCountPlace() {
        return null;
    }
}
