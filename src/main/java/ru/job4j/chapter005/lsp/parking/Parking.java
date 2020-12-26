package ru.job4j.chapter005.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private static List<Place> parking = new ArrayList<>();

    public List<Place> getParking() {
        return parking;
    }

    public void setParking(List<Place> parking) {
        this.parking = parking;
    }
}
