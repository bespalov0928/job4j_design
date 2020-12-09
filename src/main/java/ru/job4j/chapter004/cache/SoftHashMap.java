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

        SoftReference<V> value = softMap.get(key);
        V rsl = null;
        if (value == null) {
            ReadFile read = new ReadFile();
            value = new SoftReference(read.loadDate(key));
            rsl = value.get();
            softMap.put(key, value);
        } else{
            rsl = value.get();
        }
        return (V) rsl;
    }

}
