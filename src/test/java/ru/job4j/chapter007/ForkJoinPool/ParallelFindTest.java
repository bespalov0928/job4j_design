package ru.job4j.chapter007.ForkJoinPool;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.chapter007.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ParallelFindTest {

    @Test
    public void getRsl() {
        User[] arr = new User[12];
        for (int index = 0; index < arr.length; index++){
            arr[index] = new User();
        }
        int rsl = ParallelFind.getRsl(arr, arr[1]);
        System.out.println(rsl);
        assertThat(1, Is.is(rsl));
    }
}