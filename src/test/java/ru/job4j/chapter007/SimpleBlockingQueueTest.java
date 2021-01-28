package ru.job4j.chapter007;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    @Test
    public void offer() {
        SimpleBlockingQueue simpleBlockingQueue = new SimpleBlockingQueue<Integer>();
        Thread consumer = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    simpleBlockingQueue.poll();
                    System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getState());
                }, "first"
        );
        Thread producer = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    simpleBlockingQueue.offer(10);
                    System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getState());
                }, "second"
        );


        consumer.start();
        producer.start();
        try {
            consumer.join();
        } catch (InterruptedException e) {
            consumer.currentThread().interrupt();
        }

        try {
            producer.join();
        } catch (InterruptedException e) {
            producer.currentThread().interrupt();
        }
        assertThat(simpleBlockingQueue.poll(), is(10));
        //System.out.println(simpleBlockingQueue.poll());

    }

}