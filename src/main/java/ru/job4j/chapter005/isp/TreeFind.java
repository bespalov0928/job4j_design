package ru.job4j.chapter005.isp;

import java.util.Optional;

public interface TreeFind<E> {
    Optional<SimpleTree.Node<E>> findBy(E value);
}
