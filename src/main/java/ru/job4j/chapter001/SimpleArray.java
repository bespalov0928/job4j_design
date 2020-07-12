package ru.job4j.chapter001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> {

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
    public void set(int index, T model) throws IndexOutOfBoundsException {
        try {
            Objects.checkIndex(index, position);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        data[index] = (Object) model;

    }

    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
     * необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек)
     *
     * @param index
     */
    public void remove(int index) {
        Object[] tmp = new Object[3];
        data[index] = null;
        System.arraycopy(data, 0, tmp, 0, data.length);
        System.arraycopy(tmp, index, data, index, data.length - 1 -  index);
        position--;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return (T) data[position];
    }

}
