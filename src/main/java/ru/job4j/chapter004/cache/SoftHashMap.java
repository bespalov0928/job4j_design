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
        V rsl = null;
        if (softMap.containsKey(key)) {
            rsl = softMap.get(key).get();
        }

        if (rsl == null || !softMap.containsKey(key)) {
            rsl = (V) new ReadFile().loadDate(key);
            softMap.put(key, new SoftReference(rsl));
        }

        return (V) rsl;
    }

}
