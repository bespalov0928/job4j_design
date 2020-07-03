package ru.job4j.chapter001.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        while (row < data.length) {
            if (data[row].length == 0) {
                row++;
                continue;
            }
            while (column < data[row].length) {
                rsl = true;
                break;
            }
            break;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int x = 0;
        x = data[row][column];
        if (column >= data[row].length - 1) {
            column = 0;
            row++;
        } else {
            column++;
        }
        return x;
    }
}
