package ru.job4j.chapter005.lsp.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void setParkingTrackTrue() {
        ParkingCar parking = new ParkingCar(3,3);
        boolean rsl = parking.add(new CarTrack(1));
        boolean extend = true;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingTrackFalse() {
        ParkingCar parking = new ParkingCar(3,3);
        parking.add(new CarTrack(1));
        parking.add(new CarTrack(1));
        parking.add(new CarTrack(1));
        boolean rsl = parking.add(new CarTrack(1));
        boolean extend = false;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingPassengerTrue() {
        ParkingCar parking = new ParkingCar(3, 3);
        parking.add(new CarPassenger());
        boolean rsl = parking.add(new CarPassenger());
        boolean extend = true;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingPassengerFalse() {
        ParkingCar parking = new ParkingCar(3,3);
        parking.add(new CarPassenger());
        parking.add(new CarPassenger());
        parking.add(new CarPassenger());
        boolean rsl = parking.add(new CarPassenger());
        boolean extend = false;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingTrackPlacePassangerTrue() {
        ParkingCar parking = new ParkingCar(3,3);
        Car car = new CarTrack(2);
        parking.add(new CarPassenger());
        boolean rsl = parking.add(new CarTrack(2));
        boolean extend = true;
        assertThat(extend, is(rsl));
    }
}