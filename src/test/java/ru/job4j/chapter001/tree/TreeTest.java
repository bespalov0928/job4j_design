package ru.job4j.chapter001.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
       //tree.add(8, 2);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(), is(false)
        );
    }

    @Test
    public void whenisBinaryTrue() {
        Tree<Integer> tree = new Tree<>(1);
        //tree.add(8, 2);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);

        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenisBinaryFalse() {
        Tree<Integer> tree = new Tree<>(1);
        //tree.add(8, 2);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);

        assertThat(tree.isBinary(), is(false));
    }

}