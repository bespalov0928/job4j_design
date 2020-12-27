package ru.job4j.chapter005.isp;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E>, TreeAdd<E>, TreeFind<E>, TreeShow<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root, (String) root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = true;
        Optional<Node<E>> parentOptional = findBy(parent);
        Optional<Node<E>> childOptional = findBy(child);
        if (!parentOptional.isEmpty() && childOptional.isEmpty()) {
            Node<E> parentTemp = parentOptional.get();
            String prefix = "";
            Integer x = parentTemp.name.lastIndexOf("-");
            if (x > 0) {
                for (int index = 0; index <= x; index++) {
                    prefix = prefix + "-";
                }
            }
            SimpleTree.Node<E> newChild = new Node<>(child, "---" + prefix + child);
            parentTemp.child.add(newChild);
        } else {
            rsl = false;
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
            data.addAll(el.child);
        }
        return rsl;
    }

    @Override
    public String show(Optional<Node<E>> value) {
        String rsl = "";
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            rsl = rsl + el.name + System.lineSeparator();
            ((LinkedList<Node<E>>) data).addAll(0, el.child);
        }
        return rsl;
    }
}
