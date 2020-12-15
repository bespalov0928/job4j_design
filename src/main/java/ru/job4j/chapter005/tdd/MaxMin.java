package ru.job4j.chapter005.tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return loop(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return loop(value, comparator);
    }

    public <T> T loop(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (int index = 0; index < value.size() - 1; index++) {
            Integer temp = comparator.compare(value.get(index), value.get(index + 1));
            if (temp < 0) {
                rsl = value.get(index + 1);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        Integer rsl = null;

        rsl = new MaxMin().max(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return Integer.compare(first, second);
            }
        });
        System.out.println("max: "+rsl);

        rsl = new MaxMin().min(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return Integer.compare(second, first);
            }
        });
        System.out.println("min: "+rsl);
    }

}

