package ru.job4j.chapter005.isp;

import org.junit.Test;


import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void findBy() {
        Tree<String> tree = new Tree<String>("Задача 1.");
        tree.add("Задача 1.", "Задача 1.1.");
        tree.add("Задача 1.1.", "Задача 1.1.1.");
        tree.add("Задача 1.1.", "Задача 1.1.2.");
        tree.add("Задача 1.", "Задача 1.2.");
        Optional<SimpleTree.Node<String>> rsl = tree.findBy("Задача 1.");
        String str = tree.show(rsl);
        System.out.println(str);
    }
}