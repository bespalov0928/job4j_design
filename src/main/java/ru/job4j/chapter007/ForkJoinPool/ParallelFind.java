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
//        if (arr.length <= threshold) {
//            System.out.println("1");
//            rsl = sequentialSearch(arr, objectFind);
//        } else {
        System.out.println("2");
        int mid = from + to / 2;
        ParallelFind leftPart = new ParallelFind(arr, from, mid, objectFind);
        ParallelFind rightPart = new ParallelFind(arr, mid + 1, to, objectFind);

        leftPart.fork();
        rightPart.fork();

        V[] left = (V[]) leftPart.join();
        V[] right = (V[]) rightPart.join();

        int rslLeft = sequentialSearch(left, objectFind);
        int rslRight = sequentialSearch(right, objectFind);
        rsl = rslLeft == rslRight ? -1 : Integer.max(rslLeft, rslRight);
//        }

        return rsl;
    }

    private static <V> int sequentialSearch(V[] arr, V objectFind) {
        System.out.println("sequentialSearch");
        int rsl = -1;
        for (int index = 0; index < arr.length; index++) {
            System.out.println("sequentialSearch: " + index);
            if (arr[index].equals(objectFind)) {
                rsl = index;
                break;
            }
        }
//        List<V> list = new ArrayList<V>(Arrays.asList(arr));
//        list.forEach(x -> {
//            if (x.equals(objectFind)) {
//                rsl.set(list.indexOf(x));
//            }
//        });

        return rsl;
    }

    public static <V> int getRsl(V[] arr, V objectFind) {
        int rsl = -1;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ParallelFind parallelFind = new ParallelFind(arr, 0, arr.length - 1, objectFind);
        rsl = (int) forkJoinPool.invoke(parallelFind);
        System.out.println(rsl);

        return rsl;
    }

}
