package ru.job4j.chapter005.isp;

import java.util.Optional;

public interface TreeShow<E> {
    String show(Optional<SimpleTree.Node<E>> node);
}
