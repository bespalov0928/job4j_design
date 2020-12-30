package ru.job4j.chapter005.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void setParkingTrack() {
        Parking parking = new Parking(15,5);
        Car car = new CarTrack(1);
        parking.setParking(car);
        Place[] rsl = parking.getParking();

        List<PlacePassenger> extend = new ArrayList<>();
        extend.add(new PlacePassenger());
        extend.add(new PlacePassenger());
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingPassenger() {
        Parking parking = new Parking(15,5);
        Car car = new PassengerCar();
        parking.setParking(car);
        Place[] rsl = parking.getParking();

        List<PlacePassenger> extend = new ArrayList<>();
        extend.add(new PlacePassenger());
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingTrackPlacePassanger() {
        Parking parking = new Parking(15,5);
        Car car = new CarTrack(3);
        parking.setParking(car);
        Place[] rsl = parking.getParking();

        List<PlacePassenger> extend = new ArrayList<>();
        extend.add(new PlacePassenger());
        extend.add(new PlacePassenger());
        extend.add(new PlacePassenger());
        assertThat(extend, is(rsl));
    }
}