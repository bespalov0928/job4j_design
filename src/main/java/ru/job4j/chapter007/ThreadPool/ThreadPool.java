package ru.job4j.chapter007.ThreadPool;

import ru.job4j.chapter007.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreadPool {

    private static final ThreadPool INSTANSE = new ThreadPool();

    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public ThreadPool() {
        for (int index = 0; index < size; index++) {
            threads.add(new Thread(
                    () -> {
                        synchronized (ThreadPool.class) {
                            tasks.poll();
                        }
//                        tasks.poll();
                    }
            ));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static ThreadPool getInstance() {
        return INSTANSE;
    }

    public void work(Runnable job) {
        tasks.offer(job);
//        synchronized (ThreadPool.class) {
//            this.notifyAll();
//        }
    }

    public void schutdown() {
        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
