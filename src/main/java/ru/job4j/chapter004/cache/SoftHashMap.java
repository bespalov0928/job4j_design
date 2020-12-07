package ru.job4j.chapter004.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class SoftHashMap<K, V> {

    private HashMap<K, SoftReference<V>> softMap;
    //private HashMap<K, SoftReference<K>> keyMap = new HashMap<>();

    public SoftHashMap() {
        this.softMap = new HashMap<K, SoftReference<V>>();
    }

    public V take(K key) {

        SoftReference<V> rsl = softMap.get(key);
        if (rsl == null) {
            ReadFile read = new ReadFile();
            rsl = new SoftReference(read.loadDate(key));
            softMap.put(key, rsl);
        }
        return (V) rsl;
    }

}
