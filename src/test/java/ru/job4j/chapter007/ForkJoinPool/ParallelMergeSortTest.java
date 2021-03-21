package ru.job4j.chapter007.ForkJoinPool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParallelMergeSortTest {

    @Test
    public void compute() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
//        ParallelMergeSort par = new ParallelMergeSort(arr, 0, 4);
//        par.compute();
        int[] rsl = ParallelMergeSort.sort(arr);
        System.out.println(rsl);
    }
}