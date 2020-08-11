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
            //проверяем значение дочерних узлов
            ArrayList<Node<E>> chilArray = (ArrayList<Node<E>>) parentTemp.children;
            for (int x = 0; x < chilArray.size(); x++) {
                Node<E> childrenTmp = chilArray.get(x);
                if (Objects.equals(childrenTmp, child)) {
                    rsl = false;
                    break;
                }

                //проверяем значения в улах дерева дочерних узлов, если оно есть.
                ArrayList<Node<E>> childChildArray = (ArrayList<Node<E>>) childrenTmp.children;
                if (childChildArray.contains(child)) {
                    rsl = false;
                    break;
                }
//                for (int y = 0; y < childChildArray.size(); y++) {
//                    if (Objects.equals(childChildArray.get(y), child)) {
//                        rsl = false;
//                        break;
//                    }
//                }
            }
            if (rsl) {
                Node<E> newChild = new Node<>(child);
                chilArray.add(newChild);
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
