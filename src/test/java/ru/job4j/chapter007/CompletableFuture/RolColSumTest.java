package ru.job4j.chapter007.CompletableFuture;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class RolColSumTest {

    @Test
    public void sums() {
        int[][] matrix = new int[][] {{1, 2, 3},{1, 2, 3}};
        RolColSum.Sums[] rsl = RolColSum.sums(matrix);
        RolColSum.Sums was = new RolColSum.Sums();
        was.setRowSum(2);
        was.setColSum(6);
        assertThat(rsl[0], Is.is(was));
    }

    @Test
    public void asyncSums() throws ExecutionException, InterruptedException {

        int[][] matrix = new int[][] {{1, 2, 3},{1, 2, 3}};
        RolColSum.Sums[] rsl = RolColSum.asyncSums(matrix);
        RolColSum.Sums was = new RolColSum.Sums();
        was.setRowSum(2);
        was.setColSum(6);
        assertThat(rsl[0], Is.is(was));
    }
}