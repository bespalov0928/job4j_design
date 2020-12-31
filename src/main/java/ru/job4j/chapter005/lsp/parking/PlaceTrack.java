package ru.job4j.chapter005.lsp.parking;

public class PlaceTrack implements Place {
    Car car;

    @Override
    public Integer[] setPlace(Car car) {
        return new Integer[0];
    }
}
