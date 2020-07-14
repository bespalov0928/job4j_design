package ru.job4j.chapter001.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("First");
        String rsl = array.get(0);
        assertThat(rsl, is("First"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("First");
        String rsl = array.iterator().next();
        assertThat(rsl, is("First"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("First");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}