package ru.job4j.chapter001.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> {

    SimpleArray simpleArray = new SimpleArray();

    public boolean contains(T value) {
        boolean rsl = false;
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            if (it.next() == value) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public void add(T model) {
        if (!contains(model)) {
            simpleArray.add(model);
        }

    }


}
