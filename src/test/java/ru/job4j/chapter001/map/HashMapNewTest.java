package ru.job4j.chapter001.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashMapNewTest {

    @Test
    public void insert() {
        User first = new User("Ivan", 1, new GregorianCalendar(1530, 8, 25));
        User second = new User("Napoleon", 1, new GregorianCalendar(1804, 5, 18));
        User third = new User("Nikolay", 1, new GregorianCalendar(1530, 8, 25));
        User fourth = new User("Denis", 1, new GregorianCalendar(1530, 8, 25));

        HashMapNew<User, Object> map = new HashMapNew<>();
        map.insert(first, "first");
        map.insert(second, "second");
        map.insert(third, "third");
        map.insert(fourth, "fourth");
        //System.out.println(map.table);
        Iterator<User> iterator = map.iterator();
        while (iterator.hasNext()) {
            //User node = iterator.next();
            //iterator.next();
            System.out.println(iterator.next());
        }
    }


    @Test
    public void get() {
        User first = new User("Ivan", 1, new GregorianCalendar(1530, 8, 25));
        User second = new User("Marina", 1, new GregorianCalendar(1804, 5, 18));
        User third = new User("Nikolay", 1, new GregorianCalendar(1530, 8, 25));
        User fourth = new User("Denis", 1, new GregorianCalendar(1530, 8, 25));

        HashMapNew<User, Object> map = new HashMapNew<>();
        map.insert(first, "first");
        map.insert(second, "second");
        map.insert(third, "third");
        map.insert(fourth, "fourth");

        Object user = map.get(first);
        assertThat("first", is(user));
    }


    @Test
    public void delete() {
        User first = new User("Ivan", 1, new GregorianCalendar(1530, 8, 25));
        User second = new User("Napoleon", 1, new GregorianCalendar(1804, 5, 18));
        User third = new User("Nikolay", 1, new GregorianCalendar(1530, 8, 25));
        User fourth = new User("Denis", 1, new GregorianCalendar(1530, 8, 25));

        HashMapNew<User, Object> map = new HashMapNew<>();
        map.insert(first, "first");
        map.insert(second, "second");
        map.insert(third, "third");
        map.insert(fourth, "fourth");

        Iterator<User> it = map.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        Object user = map.delete(first);

        Iterator<User> iterator = map.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}