package ru.job4j.chapter005.lsp.parking;

public class CarPassenger implements Car {

    private final boolean track = true;

    @Override
    public Integer getCountPlace() {
        return 1;
    }
    @Override
    public boolean isCar() {
        return track;
    }
}
