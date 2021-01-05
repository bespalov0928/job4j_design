package ru.job4j.chapter005.lsp.parking;

public class CarTrack implements Car {

    private Integer counrPlacePark;
    private final boolean track = false;

    public CarTrack(Integer counrPlacePark) {
        this.counrPlacePark = counrPlacePark;
    }

    @Override
    public Integer getCountPlace() {
        return counrPlacePark;
    }
    @Override
    public boolean isCar() {
        return track;
    }

}
