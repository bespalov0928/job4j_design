package ru.job4j.chapter001;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 1. Генератор текста
 */
public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = false;
        String[] arrLeft = origin.split("[[ ]*|[,]*|[\\\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");
        String[] arrRight = line.split("[[ ]*|[,]*|[\\\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");
        HashSet<String> setLeft = new HashSet<>();
        setLeft.addAll(Arrays.asList(arrLeft));
        //setLeft.removeAll(Arrays.asList(arrRight));
        if (setLeft.containsAll(Arrays.asList(arrRight))) {
            rsl = true;
        }
        return rsl;
    }
}
