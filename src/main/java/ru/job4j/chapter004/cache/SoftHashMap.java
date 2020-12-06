package ru.job4j.chapter004.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class SoftHashMap<K, V> {

    private HashMap<SoftReference<K>, V> softMap;
    private HashMap<K, SoftReference<K>> keyMap = new HashMap<>();

    public SoftHashMap() {
        this.softMap = new HashMap<SoftReference<K>, V>();
    }


    public V take(K key) {
        SoftReference newKey = keyMap.get(key);
        if (newKey == null) {
            newKey = new SoftReference(key);
            keyMap.put(key, newKey);

        }

        V rsl = softMap.get(newKey);
        if (rsl == null) {
            ReadFile read = new ReadFile();
            rsl = (V) read.loadDate(key);

            softMap.put(newKey, rsl);
        }
        return rsl;
    }

}
