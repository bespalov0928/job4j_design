package ru.job4j.chapter005.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SimpleTree<E> {
//    boolean add(E parent, E child);

//    Optional<Node<E>> findBy(E value);

    class Node<E> {
        final String name;
        final E value;
        final List<Node<E>> child = new ArrayList<>();

        public Node(E value, String name) {
            this.value = value;
            this.name = name;
        }
    }
}
