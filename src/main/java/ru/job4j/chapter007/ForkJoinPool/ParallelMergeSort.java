package ru.job4j.chapter007.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMergeSort extends RecursiveTask<int[]> {
    private final int[] array;
    private final int from;
    private final int to;

    public ParallelMergeSort(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    protected int[] compute() {
        System.out.println("compute");
        if (from == to) {
            System.out.println("if (from == to): " + from);
            return new int[]{array[from]};
        }
        //System.out.println("2");
        int mid = (from + to) / 2;
        //System.out.println("int mid = (from + to) / 2");
        ParallelMergeSort leftSort = new ParallelMergeSort(array, from, mid);
        ParallelMergeSort rightSort = new ParallelMergeSort(array, mid + 1, to);
        System.out.println("new ParallelMergeSort(array, from, mid), length: "+array.length +", mid : "+ mid + ", from: " + from + ", to: "+to);

        System.out.println("fork start, length: "+array.length +", mid : "+ mid + ", from: " + from + ", to: "+to);
        leftSort.fork();
        System.out.println("fork end, length: "+array.length +", mid : "+ mid + ", from: " + from + ", to: "+to);
        rightSort.fork();

        System.out.println("join start, length: ");
        int[] left = leftSort.join();
        System.out.println("join end, length: " + left.length);
        int[] right = rightSort.join();

        int[] rsl = MergeSort.merge(left, right);
        System.out.println("MergeSort.merge(left, right), length: " + left.length);

        return rsl;

    }

    public static int[] sort(int[] arr) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new ParallelMergeSort(arr, 0, arr.length - 1));
    }
}
