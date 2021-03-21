package ru.job4j.chapter007.CompletableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Matrix {

    public static int[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        int n = matrix.length;
        int[] sums = new int[2 * n];
        Map<Integer, CompletableFuture<Integer>> futures = new HashMap<>();

        //считаем суммы по главной диагонали
        futures.put(0, getTask(matrix, 0, n - 1, n - 1));

        //считаем суммы по побочным диагоналям
        for (int r = 1; r <= n; r++) {
            futures.put(r, getTask(matrix, 0, r - 1, r - 1));
            if (r < n) {
                futures.put(2 * n - r, getTask(matrix, n - r, n - 1, n - 1));
            }
        }

        for (Integer key : futures.keySet()) {
            sums[key] = futures.get(key).get();
        }

        return sums;
    }

    public static CompletableFuture<Integer> getTask(int[][] data, int startRow, int endRow, int startCol) {
        CompletableFuture<Integer> rsl;
        rsl = CompletableFuture.supplyAsync(
                () -> {
                    int sum = 0;
                    int col = startCol;
                    for (int i = startRow; i <= endRow; i++) {
                        sum += data[i][col];
                        col--;
                    }
                    return sum;
                }
        );
        return rsl;
    }

    public static void main(String[] args) {
        int[][] marrix = new int[][]{{1, 2, 3},{1, 2, 3}};
        int[] rsl = null;
        try {
            rsl = asyncSum(marrix);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(rsl);
    }
}
