package ru.job4j.chapter001.generic;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] data;
    private int position = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    /**
     * добавляет указанный элемент (model) в первую свободную ячейку
     *
     * @param model
     */
    public void add(T model) {
        data[position++] = model;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index
     *
     * @param index
     * @param model
     */
    public void set(int index, T model) {
        if (Objects.checkIndex(index, position) >= 0) {
            data[index] = (Object) model;
        }
    }

    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
     * необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек)
     *
     * @param index
     */
    public void remove(int index) {
        int lastIndex = data.length - 1 - index;
        System.arraycopy(data, index + 1, data, index, lastIndex);
        data[lastIndex + 1] = null;
        position--;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     *
     * @param index
     * @return
     */
    public T get(int index) {
        T rsl = null;
        if (Objects.checkIndex(index, position) >= 0) {
            rsl = (T) data[position];
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {


        Iterator<T> it = new Iterator<T>() {
            int point = 0;

            @Override
            public boolean hasNext() {
                return point > 0 || point < data.length;
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
