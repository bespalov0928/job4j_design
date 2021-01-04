package ru.job4j.chapter005.lsp.parking;

import java.util.List;

public class ParkingTrack implements Parking {

    private static PlaceAll[] parkingArr;

    public ParkingTrack(int countPlace) {
        for (int index = 0; index < countPlace; index++) {
            parkingArr = new PlaceAll[countPlace];
        }
    }

    @Override
    public boolean accept(Car car) {
        boolean rsl = false;
        for (PlaceAll place : parkingArr) {
            if (place.getCar() == car) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean add(Car car) {
        boolean rsl = false;
        for (int index = 0; index < parkingArr.length; index++) {
            if (parkingArr[index] == null) {
                parkingArr[index] = new PlaceAll(car);
                rsl = true;
            }
        }
        return rsl;
    }
}
