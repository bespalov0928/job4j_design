package ru.job4j.chapter005.lsp.parking;

public class Parking implements ParkingInteface {
    private static Place[] parkingArr = new Place[20];

    public Parking(int passengerPlace, int trackPlace) {
        for (int index = 0; index < passengerPlace; index++) {
            parkingArr[index] = new PlacePassenger();
        }
        for (int index = 0; index < trackPlace; index++) {
            parkingArr[index] = new PlaceTrack();
        }
    }

    public void setParking(Car car, Place plase) {
        Integer[] arrPlace = plase.setPlace(car);
        //todo
    }
}
