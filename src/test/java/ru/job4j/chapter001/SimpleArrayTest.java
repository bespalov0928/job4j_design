package ru.job4j.chapter001;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Arrays;

public class SimpleArrayTest {

    @Test
    public void addTest() {
        Integer[] result = new Integer[3];
        result[0] = 1;
        //array[0] = 1;
        result[2] = 3;

        new SimpleArray<Integer>(result).add(2);
        Integer[] expected = new Integer[3];
        expected[0] = 1;
        expected[1] = 2;
        expected[2] = 3;
        assertThat(result, is(expected));
    };

    @Test
    public void setTest() {
        Integer[] result = new Integer[3];
        result[0] = 1;
        result[1] = 2;
        result[2] = 3;

        new SimpleArray<Integer>(result).set(2, 4);
        Integer[] expected = new Integer[3];
        expected[0] = 1;
        expected[1] = 2;
        expected[2] = 4;
        assertThat(result, is(expected));
    };

    @Test
    public void removeTest() {
        Integer[] result = new Integer[3];
        result[0] = 1;
        result[1] = 2;
        result[2] = 3;

        new SimpleArray<Integer>(result).remove(1);
        Integer[] expected = new Integer[3];
        expected[0] = 1;
        expected[1] = 3;
        expected[2] = null;
        assertThat(result, is(expected));
    };

    @Test
    public void getTest() {
        Integer[] arr = new Integer[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        Integer result = new SimpleArray<Integer>(arr).get(2);

        assertThat(result, is(3));
    };


}