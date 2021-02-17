package ru.job4j.chapter007.ForkJoinPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelFind<V> extends RecursiveTask<Integer> {

    private final V[] arr;
    private final int from;
    private final int to;
    private final int threshold = 10;
    private final V objectFind;


    public ParallelFind(V[] arr, int from, int to, V objectFind) {
        this.arr = arr;
        this.from = from;
        this.to = to;
        this.objectFind = objectFind;
    }

    @Override
    protected Integer compute() {
        int rsl = -1;

        if (to - from < 10) {
            V[] arrCopy = (V[]) new Object[to - from + 1];
            rsl = sequentialSearch(arr, objectFind, from, to);
            return rsl;
        }

        int mid = from + to / 2;
        ParallelFind leftPart = new ParallelFind(arr, from, mid, objectFind);
        ParallelFind rightPart = new ParallelFind(arr, mid + 1, to, objectFind);

        leftPart.fork();
        rightPart.fork();

        int left = (int) leftPart.join();
        int right = (int) rightPart.join();

        rsl = left == right ? -1 : Integer.max(left, right);
        return rsl;
    }

    private static <V> int sequentialSearch(V[] arr, V objectFind, int from, int to) {
        int rsl = -1;
        for (int index = from; index <= to; index++) {
            if (arr[index].equals(objectFind)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public static <V> int getRsl(V[] arr, V objectFind) {
        int rsl = -1;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ParallelFind parallelFind = new ParallelFind(arr, 0, arr.length - 1, objectFind);
        rsl = (int) forkJoinPool.invoke(parallelFind);
        return rsl;
    }

}
