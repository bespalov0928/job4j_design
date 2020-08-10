package ru.job4j.chapter001.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentOptional = (Optional<Node<E>>) findBy(parent);
        if (parentOptional.isPresent()) {
            Node<E> parentTemp = (Node<E>) parentOptional.get();
            ArrayList<Node<E>> childrenTmp = (ArrayList<Node<E>>) parentTemp.children;
            if (!childrenTmp.contains(child)) {
                Node<E> newChild = new Node<>(child);
                childrenTmp.add(newChild);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
