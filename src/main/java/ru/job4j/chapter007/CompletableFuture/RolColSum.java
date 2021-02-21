package ru.job4j.chapter007.CompletableFuture;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RolColSum {
    public static class Sums {
        private int rowSum = 0;
        private int colSum = 0;

        public int getRowSum() {
            return rowSum;
        }

        public void setRowSum(int rowSum) {
            this.rowSum = rowSum;
        }

        public int getColSum() {
            return colSum;
        }

        public void setColSum(int colSum) {
            this.colSum = colSum;
        }

        @Override
        public String toString() {
            return String.format("rowSum{%s} colSum{%s}", rowSum, colSum);
        }   }



    public static Sums[] sums(int[][] matrix) {
        int n = matrix.length;
        int maxIndex = Integer.max(matrix.length, matrix[0].length);
        Sums[] rsl = new Sums[maxIndex];
        for (int x = 0; x < maxIndex; x++) {
            Sums sums = getTaska(matrix, x, maxIndex);
            rsl[x] = sums;
        }

        return rsl;
    }

    private static Sums getTaska(int[][] matrix, int index, int maxIndex) {
        Sums sums = new Sums();
        for (int col = 0; col < maxIndex; col++) {
            for (int row = 0; row < maxIndex; row++) {
                int temp = col >= matrix.length || row >= matrix[0].length ? 0 : matrix[col][row];

                //по колонке складываем
                if (col == index) {
                    sums.setColSum(sums.getColSum() + temp);
                }

                //по строке складываем
                if (row == index) {
                    sums.setRowSum(sums.getRowSum() + temp);
                }
            }
        }
        return sums;
    }


    public static Sums[] asyncSums(int[][] matrix) throws ExecutionException, InterruptedException {
        int n = matrix.length;
        int maxIndex = Integer.max(matrix.length, matrix[0].length);
        Sums[] rsl = new Sums[maxIndex];
        Map<Integer, CompletableFuture<Sums>> futures = new HashMap<>();
        for (int x = 0; x < maxIndex; x++) {
            futures.put(x, getTaskaSync(matrix, x, maxIndex));
        }

        for (Integer key : futures.keySet()) {
            Sums sums = futures.get(key).get();
            rsl[key] = sums;
        }

        return rsl;

    }

    private static CompletableFuture<Sums> getTaskaSync(int[][] matrix, int index, int maxIndex) {
        CompletableFuture<Sums> rsl = null;

        rsl = CompletableFuture.supplyAsync(
                () -> {
                    Sums sums = new Sums();
                    for (int col = 0; col < maxIndex; col++) {
                        for (int row = 0; row < maxIndex; row++) {
                            int temp = col >= matrix.length || row >= matrix[0].length ? 0 : matrix[col][row];

                            //по колонке складываем
                            if (col == index) {
                                sums.setColSum(sums.getColSum() + temp);
                            }

                            //по строке складываем
                            if (row == index) {
                                sums.setRowSum(sums.getRowSum() + temp);
                            }
                        }
                    }
                    return sums;
                });
        return rsl;
    }
}
