package ru.job4j.chapter005.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void getParking() {

    }

    @Test
    public void setParkingTrack() {
        Parking parking = new Parking();
        Car car = new CarTrack(2);
        List<Place> list = car.getCountPlace();
        parking.setParking(list);
        List<Place> rsl = parking.getParking();
        List<Place> extend = new ArrayList<>();
        extend.add(new Place());
        extend.add(new Place());
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingPassenger() {
        Parking parking = new Parking();
        Car car = new PassengerCar(1);
        List<Place> list = car.getCountPlace();
        parking.setParking(list);
        List<Place> rsl = parking.getParking();
        List<Place> extend = new ArrayList<>();
        extend.add(new Place());
        assertThat(extend, is(rsl));
    }
}