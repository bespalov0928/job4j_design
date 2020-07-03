package ru.job4j.chapter001.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        if (point < numbers.length) {
            while (numbers[point] % 2 != 0) {
                point++;
                if (point >= numbers.length) {
                    break;
                }
            }
            rsl = point < numbers.length;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[point++];
    }
}
