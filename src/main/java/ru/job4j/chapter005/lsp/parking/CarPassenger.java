package ru.job4j.chapter005.lsp.parking;

public class CarPassenger implements Car {

    @Override
    public Integer getCountPlace() {
        return 1;
    }

}
