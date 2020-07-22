package ru.job4j.chapter001.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T>  {

    SimpleArray simpleArray = new SimpleArray();

    public T get(int index) {
        return (T) simpleArray.get(index);
    }

    public void add(T model) {
        simpleArray.add(model);
    }


}
