package ru.job4j.chapter001.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapNotEquals {

    public static void main(String[] args) {
        User first = new User("Ivan", 1, new GregorianCalendar(1530, 8, 25));
        User second = new User("Napoleon", 1, new GregorianCalendar(1804, 5, 18));
        User third = new User("Ivan", 1, new GregorianCalendar(1530, 8, 25));

        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(third, "third");
        System.out.println(map);
    }
}

