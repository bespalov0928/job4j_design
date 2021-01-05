package ru.job4j.chapter005.lsp.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingCar implements Parking {
    private List<Car> parkingCar = new ArrayList<>();
    private List<Car> parkingTrack = new ArrayList<>();
    private final int countCar;
    private final int countTrack;


    public ParkingCar(int countCar, int countTrack) {
        this.countCar = countCar;
        this.countTrack = countTrack;
    }

    /**
     * возвращает истина если машина уже стоит на парковке
     *
     * @param car
     * @return
     */
    @Override
    public boolean accept(Car car) {
        if (car.isCar()) {
            for (Car placeCar : parkingCar) {
                if (placeCar.equals(car)) {
                    return true;
                }
            }
        } else {
            for (Car placeCar : parkingTrack) {
                if (placeCar.equals(car)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * добавляет машину на парковку
     *
     * @param car
     * @return
     */
    @Override
    public boolean add(Car car) {
        boolean rsl = false;
        if (car.isCar() && parkingCar.size() < countCar) {
            parkingCar.add(car);
            rsl = true;
        } else if (!car.isCar() && parkingTrack.size() < countTrack && car.getCountPlace().equals(1)) {
            parkingTrack.add(car);
            rsl = true;
        } else if (!car.isCar() && parkingTrack.size() < (countTrack + car.getCountPlace())&& !car.getCountPlace().equals(1)) {
            for (int index = 0; index < car.getCountPlace(); index++) {
                parkingTrack.add(car);
                rsl = true;
            }
        }
        return rsl;
    }
}
