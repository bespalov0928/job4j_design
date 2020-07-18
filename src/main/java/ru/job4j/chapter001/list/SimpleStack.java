package ru.job4j.chapter001.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    /**
     * должен возвращать первое значение и удалять его из коллекции
     * @return
     */
    public T pop() {
        T value = linked.deleteFirst();
        return value;
    }

    /**
     * помещает значение в конец коллекции.
     * @param value
     */
    public void push(T value) {
        linked.add(value);
    }

    public boolean isEmpty() {
        return linked.iterator().hasNext();
    }

}
