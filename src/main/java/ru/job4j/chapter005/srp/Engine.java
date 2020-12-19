package ru.job4j.chapter005.srp;

/**
 * объединение двух разных процедур в одном интерфейсе
 */
public interface Engine {
    Integer temperatureOil(Integer t);
    Integer pressureOil();
}
