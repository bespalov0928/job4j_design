package ru.job4j.chapter004.cache;

import java.util.ArrayList;

public interface Load<K, V> {

    public K loadDate(V path);

}
