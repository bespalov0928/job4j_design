package ru.job4j.chapter007;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.*;
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


    @Test
    public void test1() {
        CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(
                () -> {
                    IntStream.range(0, 5).forEach(
                            queue::offer
                    );
                }
        );

        Thread consumer = new Thread(
                () -> {
                    System.out.println(queue.isEmpty() +" : " + Thread.currentThread().isInterrupted());
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        int temp = queue.poll();
                        System.out.println(temp);
                        buffer.add(temp);
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();
        producer.start();

        try {
            producer.join();
            System.out.println("producer.join()");
        } catch (InterruptedException e) {
            producer.interrupt();
        }
        consumer.interrupt();
        System.out.println("consumer.interrupt()");
        try {
            System.out.println("consumer.join()");
            consumer.join();
        } catch (InterruptedException e) {
            consumer.interrupt();
        }

        assertThat(buffer, is(Arrays.asList(0,1,2,3,4)));
    }

}