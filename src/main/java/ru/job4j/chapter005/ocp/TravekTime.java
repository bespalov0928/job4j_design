package ru.job4j.chapter005.ocp;

public class TravekTime {

    /**
     * второй параметр задается конкретным классом
     * должен задаваться интерфейсом
     *
     * поле weatherKoef нужно передавать параметром
     * @param distance
     * @param bus
     * @return
     */
    public double calculate(int distance, Bus bus) {

        double weatherKoef = 0.5;
        double rsl = (Integer) distance * bus.getKoef() * weatherKoef;
        return rsl;
    }

}
