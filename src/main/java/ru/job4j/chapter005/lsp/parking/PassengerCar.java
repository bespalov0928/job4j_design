package ru.job4j.chapter005.lsp.parking;

public class PassengerCar implements Car {

    @Override
    public Integer getCountPlace() {
        return 1;
    }

    @Override
    public Integer[] setPlace(Place[] arr) {
        return null;
    }
}
