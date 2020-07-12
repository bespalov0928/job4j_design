package ru.job4j.chapter001;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class SimpleIterator<T> implements Iterable<T> {
    private Object[] data;
    private int point = 0;

    public int getPoint() {
        return point;
    }

    public SimpleIterator(T[] data) {
        this.data = data;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return point < data.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    new NoSuchElementException();
                }
                return (T) data[point++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

        };
        return it;
    }
}
