package ru.job4j.it;

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
        if (data.length == 0) {
            return false;
        } else if (row == data.length - 1 && data[row].length == 0) {
            return false;
        } else {
            return row < data.length || column < data[row].length;
        }
    }

    @Override
    public Integer next() {
        int x = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (data[row].length == 0) {
            while (data[row].length == 0 && row < data.length) {
                row++;
            }
        }
        x = data[row][column];
        column++;
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        return x;
    }
}
