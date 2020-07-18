package ru.job4j.chapter001.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;

    /**
     * помещает значение в конец коллекции.
     *
     * @param value
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * возвращает значение первого элемента и удаляет его.
     *
     * @return
     */
    public T deleteFirst() {
        Node<T> tmp = null;
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public void  revert() {

        Iterator<T> it = iterator();
        T tempValue = null;
        //первому next указываешь null, а каждому последующему предыдущий
        while (it.hasNext()) {
            tempValue = it.next();
            Node<T> tempNode = new Node<T>(tempValue, head);
            //nextNode = tempNode;
            head = tempNode;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
