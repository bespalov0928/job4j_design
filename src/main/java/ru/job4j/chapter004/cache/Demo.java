package ru.job4j.chapter004.cache;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {


        SoftHashMap cache = new SoftHashMap();
        ArrayList temp1 = (ArrayList) cache.take("Names.txt");
        ArrayList temp2 = (ArrayList) cache.take("Address.txt");
        System.gc();
        ArrayList temp3 = (ArrayList) cache.take("Names.txt");
    }
}
