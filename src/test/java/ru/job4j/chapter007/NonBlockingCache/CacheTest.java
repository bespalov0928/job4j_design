package ru.job4j.chapter007.NonBlockingCache;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CacheTest {

    @Test
    public void updateTrue() {
        Cache cache = new Cache();
        Base basefirst = new Base(1, "basefirst", 0);
        cache.add(basefirst);

        cache.add(basefirst);
        Thread first = new Thread(
                () -> {
                    System.out.println("first");
                    Base temp = new Base(cache.get(1).getId(), "basefirst1", cache.get(1).getVersion());
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("first 1");
                    cache.update(temp);
                    System.out.println(temp.getName());
                }
        );
        Thread second = new Thread(
                () -> {
                    System.out.println("second");
                    Base temp = new Base(cache.get(1).getId(), "basefirst2", cache.get(1).getVersion());
                    cache.update(temp);
                    System.out.println(temp.getName());
                }
        );


        first.start();
        second.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(cache.get(1).getVersion() + " : " + cache.get(1).getName());
        assertThat("basefirst2", is(cache.get(1).getName()));
    }

    @Test
    public void updateFalse() {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Cache cache = new Cache();
        Base basefirst = new Base(1, "basefirst", 0);
        cache.add(basefirst);

        cache.add(basefirst);
        Thread first = new Thread(
                () -> {
                    System.out.println("first");
                    Base temp = new Base(cache.get(1).getId(), "basefirst1", cache.get(1).getVersion());
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("first 1");
                    cache.update(temp);
                    if (!cache.get(1).getName().equals(temp.getName())) {
                        try {
                            throw new RuntimeException("Throw Exception in Thread");
                        } catch (Exception e) {
                            ex.set(e);
                        }
                    }
                    System.out.println(temp.getName());
                }
        );
        Thread second = new Thread(
                () -> {
                    System.out.println("second");
                    Base temp = new Base(cache.get(1).getId(), "basefirst2", cache.get(1).getVersion());
                    cache.update(temp);
                    System.out.println(temp.getName());
                }
        );

        first.start();
        second.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(cache.get(1).getVersion() + " : " + cache.get(1).getName());
        assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));

    }
}