package ru.job4j.chapter005.lsp.parking;

import java.util.List;

public interface Car {
    Integer getCountPlace();

    Integer[] setPlace(Place[] arr);
}
