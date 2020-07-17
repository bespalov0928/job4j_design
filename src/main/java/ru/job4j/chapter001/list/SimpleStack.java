package ru.job4j.chapter001.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    public T pop() {
        T value =linked.deleteFirst();
        return value;
    }

    public void push(T value) {
        linked.add(value);
    }
}
