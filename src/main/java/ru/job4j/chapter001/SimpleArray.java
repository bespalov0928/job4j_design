package ru.job4j.chapter001;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleArray<T> {

    private T[] data;

    public SimpleArray(T[] data) {
        this.data = data;
    }

    /**
     * добавляет указанный элемент (model) в первую свободную ячейку
     *
     * @param model
     */
    public void add(T model) {
        Iterable itr = new SimpleIterator(data);
        Iterator it = itr.iterator();
        while (it.next() != null) {
            it.hasNext();
        }
        data[((SimpleIterator) itr).getPoint() - 1] = model;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index
     *
     * @param index
     * @param model
     */
    public void set(int index, T model) {
        Iterable itr = new SimpleIterator(data);
        Iterator it = itr.iterator();
        int x = 0;
        while (it.hasNext() && ((SimpleIterator) itr).getPoint() != index) {
            it.next();
        }
        data[((SimpleIterator) itr).getPoint()] = model;

    }

    /**
     * удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
     * необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек)
     *
     * @param index
     */
    public void remove(int index) {
        Iterable itr = new SimpleIterator(data);
        Iterator it = itr.iterator();
        int x = 0;
        while (it.hasNext() && ((SimpleIterator) itr).getPoint() < index) {
            it.next();
        }
        it.next();
        while (it.hasNext() && ((SimpleIterator) itr).getPoint() < data.length) {
            data[((SimpleIterator) itr).getPoint() - 1] = (T) it.next();
        }
        data[((SimpleIterator) itr).getPoint() - 1] = null;
    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     *
     * @param index
     * @return
     */
    public T get(int index) {
        Iterable itr = new SimpleIterator(data);
        Iterator it = itr.iterator();
        T x = null;
        while (it.hasNext() && ((SimpleIterator) itr).getPoint() <= index) {
            if (((SimpleIterator) itr).getPoint() == index) {
                x = (T) it.next();
            } else {
                it.next();
            }
        }
        return x;
    }
}
