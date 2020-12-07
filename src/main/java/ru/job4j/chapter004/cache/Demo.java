package ru.job4j.chapter004.cache;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {


        SoftHashMap cache = new SoftHashMap();
        SoftReference<ArrayList> temp1 = (SoftReference<ArrayList>) cache.take("Names.txt");
        SoftReference<ArrayList> temp2 = (SoftReference<ArrayList>) cache.take("Address.txt");
        System.gc();
        SoftReference<ArrayList> temp3 = (SoftReference<ArrayList>) cache.take("Names.txt");
    }
}
