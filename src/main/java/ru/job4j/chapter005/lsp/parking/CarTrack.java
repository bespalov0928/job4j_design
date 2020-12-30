package ru.job4j.chapter005.lsp.parking;

public class CarTrack implements Car {
    private Integer counrPlacePark;

    public CarTrack(Integer counrPlacePark) {
        this.counrPlacePark = counrPlacePark;
    }

    @Override
    public Integer getCountPlace() {
        return counrPlacePark;
    }

    @Override
    public Integer[] setPlace(Place[] arr) {
        return null;
    }
}
