package ru.job4j.chapter005.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void setParkingTrackTrue() {
        ParkingTrack parking = new ParkingTrack(3);
        boolean rsl = parking.add(new CarTrack(1));
        boolean extend = true;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingTrackFalse() {
        ParkingTrack parking = new ParkingTrack(3);
        Car car = new CarTrack(1);
        parking.add(new CarTrack(1));
        parking.add(new CarTrack(1));
        boolean rsl = parking.add(new CarTrack(1));
        boolean extend = false;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingPassengerTrue() {
        ParkingPassenger parking = new ParkingPassenger(3);
        parking.add(new CarPassenger());
        boolean rsl = parking.add(new CarPassenger());
        boolean extend = true;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingPassengerFalse() {
        ParkingPassenger parking = new ParkingPassenger(3);
        parking.add(new CarPassenger());
        parking.add(new CarPassenger());
        parking.add(new CarPassenger());
        boolean rsl = parking.add(new CarPassenger());
        boolean extend = false;
        assertThat(extend, is(rsl));
    }

    @Test
    public void setParkingTrackPlacePassangerTrue() {
        ParkingPassenger parking = new ParkingPassenger(3);
        Car car = new CarTrack(2);
        parking.add(new CarPassenger());
        boolean rsl = parking.add(new CarTrack(2));
        boolean extend = true;

        assertThat(extend, is(rsl));
    }
}