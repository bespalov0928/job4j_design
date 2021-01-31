package ru.job4j.chapter007;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CASСountTest {

    @Test
    public void increment() {
        CASСount count = new CASСount();
        Thread first = new Thread(
                ()->{
                    count.increment();
                }
        );

        Thread second = new Thread(
                ()->{
                    count.increment();
                }
        );

        first.start();

        second.start();

        try {
            first.join();
        } catch (InterruptedException e) {
            first.interrupt();
        }
        try {
            second.join();
        } catch (InterruptedException e) {
            second.interrupt();
        }
        assertThat(count.get(),is(2));
    }

    @Test
    public void get() {
    }
}