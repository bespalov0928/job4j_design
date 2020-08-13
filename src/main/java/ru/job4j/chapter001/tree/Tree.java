package ru.job4j.chapter001.tree;

import java.util.*;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = true;
        Optional<Node<E>> parentOptional = (Optional<Node<E>>) findBy(parent);

        if (parentOptional.isPresent()) {
            Node<E> parentTemp = (Node<E>) parentOptional.get();
            Queue<Node<E>> data = new LinkedList<>();
            data.addAll(parentTemp.children);
            while (!data.isEmpty()) {
                Node<E> el = data.poll();
                Optional<Node<E>> childOptional = (Optional<Node<E>>) findBy(el.value);
                if (childOptional.isEmpty()) {
                    rsl = false;
                    break;
                }
            }
            if (rsl) {
                Node<E> newChild = new Node<>(child);
                parentTemp.children.add(newChild);
            }
        }
        return rsl;
    }

//    public boolean isBinary() {
//        boolean rsl = true;
//        Node<E> tmp = this.root;
//        while (tmp.children.size())
//        return rsl;
//    }

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
