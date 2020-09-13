package ru.job4j.chapter002.Io.Serialization;

import java.util.Arrays;

public class Car {
    private boolean truck;
    private int power;
    private String brand;
    private Owner owner;
    private String[] drivers;

    public Car(boolean truck, int power, String brand, Owner owner, String[] drivers) {
        this.truck = truck;
        this.power = power;
        this.brand = brand;
        this.owner = owner;
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Car{" +
                "truck=" + truck +
                ", power=" + power +
                ", brand='" + brand + '\'' +
                ", owner=" + owner +
                ", drivers=" + Arrays.toString(drivers) +
                '}';
    }
}
