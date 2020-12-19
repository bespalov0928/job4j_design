package ru.job4j.chapter005.srp;

import java.util.Random;

public class EngineDemo implements Engine {

    /**
     *
     * @param t
     * @return
     * в методе присутстувует генератор, нужно отделить реализацию генератора от метода.
     */
    @Override
    public Integer temperatureOil(Integer t) {
        return t * new Random().nextInt(150);
    }

    @Override
    public Integer pressureOil() {
        return null;
    }
}
