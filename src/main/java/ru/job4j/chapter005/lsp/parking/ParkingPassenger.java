package ru.job4j.chapter005.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPassenger implements Parking {
    private static PlaceAll[] parkingArr;

    public ParkingPassenger(int countPlace) {
        parkingArr = new PlaceAll[countPlace];
    }

    /**
     * возвращает истина если машина уже стоит на парковке
     *
     * @param car
     * @return
     */
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

    /**
     * добавляет машину на парковку
     *
     * @param car
     * @return
     */
    @Override
    public boolean add(Car car) {
        boolean rsl = false;
        List<Integer> intList = findPlace(car.getCountPlace());
        if (intList.size() > 0) {
            rsl = true;
        }
        for (Integer el : intList) {
            parkingArr[el] = new PlaceAll(car);
        }
        return rsl;
    }

    private List<Integer> findPlace(int countPlace) {
        List<Integer> rslList = new ArrayList<>();
        List<Integer> listZero = new ArrayList<>();
        /**
         * отбор всех не занятых мест
         */
        for (int index = 0; index < parkingArr.length; index++) {
            if (parkingArr[index] == null) {
                listZero.add(index);
            }
        }

        /**
         * поиск N подряд свободных мест
         */
        for (int index = 0; index < listZero.size(); index++) {
            int intTemp = listZero.get(index).intValue();
            for (int x = 0; x < countPlace; x++) {
                if (listZero.get(index + x).intValue() != intTemp + x) {
                    intTemp = -1;
                    break;
                }
            }

            if (intTemp >= 0) {
                for (int x = 0; x < countPlace; x++) {
                    rslList.add(intTemp + x);
                }
                break;
            }

        }
        return rslList;
    }
}
