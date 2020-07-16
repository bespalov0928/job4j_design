package ru.job4j.chapter001.list;

import java.util.*;

public class SimpleLinked<E> implements Iterable<E> {

    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    private int modCount = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(E value) {
        if (first == null) {
            Node newNode = new Node(null, value, null);
            first = newNode;
            last = newNode;
        } else {
            Node newNode = new Node(last, value, null);
            last.next = newNode;
            //newNode.prev = last;
            last = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return (E) rsl.item;
    }

    @Override
    public Iterator<E> iterator() {

        Iterator<E> it = new Iterator<E>() {
            int point = 0;
            int expectedModCount = modCount;
            Node tmp = first;
            Node rsl = first;
            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (tmp == first) {
                    tmp = tmp.next;
                }  else {
                    rsl = rsl.next;
                }
                point++;
                System.out.println(rsl.item);
                return (E) rsl.item;
            }
        };

        return it;
    }
}
