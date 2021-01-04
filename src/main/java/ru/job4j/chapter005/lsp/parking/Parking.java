package ru.job4j.chapter005.lsp.parking;

import java.util.function.Consumer;

public interface Parking {

    boolean accept(Car car);

    boolean add(Car car);

}
