package ru.job4j.chapter007.ThreadPool;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadPoolTest {

    @Test
    public void test() {
        ThreadPool threadPool = new ThreadPool();
        threadPool.work(()->{
            System.out.println("task1");
        });
        threadPool.work(()->{
            System.out.println("task2");
        });
        threadPool.work(()->{
            System.out.println("task3");
        });

        System.out.println("1");
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
    }
}