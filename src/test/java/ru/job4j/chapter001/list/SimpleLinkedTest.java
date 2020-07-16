package ru.job4j.chapter001.list;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleLinkedTest {

    @Test
    public void add() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.add(1);
        simpleLinked.add(2);
        simpleLinked.add(3);
    }

    @Test
    public void get() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.add(1);
        simpleLinked.add(2);
        simpleLinked.add(3);
        simpleLinked.get(2);
    }

    @Test
    public void iterat() {
        SimpleLinked<Integer> simpleLinked = new SimpleLinked<>();
        simpleLinked.add(1);
        simpleLinked.add(2);
        simpleLinked.add(3);
        simpleLinked.add(4);
        simpleLinked.add(5);
        Iterator it = simpleLinked.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
    }
}