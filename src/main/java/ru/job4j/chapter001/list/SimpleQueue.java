package ru.job4j.chapter001.list;

import java.util.Iterator;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * должен возвращать первое значение и удалять его из коллекции.
     * @return
     */
    public T poll() {
        while (in.isEmpty()) {
            out.push(in.pop());
        }
        T value = out.pop();
        return value;
    }

    /**
     *  помещает значение в конец.
     * @param value
     */
    public void push(T value) {
        in.push(value);
    }
}
