package ru.job4j.chapter001.list;

import java.lang.reflect.Array;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    Object[] data = null;
    int position = 0;
    int modCount = 0;

    public SimpleArray() {
        this.data = new Object[10];
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) data[index];
    }

    public void add(T model) {

        if (position == data.length) {
            Object[] tmp = Arrays.copyOf(data, data.length);
            Object[] data = new Object[tmp.length + 100];
            System.arraycopy(tmp, 0, data, 0, position - 1);
        }
        data[position++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            int point = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return position > 0 && point < data.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) data[point++];
            }
        };
        return it;
    }
}
