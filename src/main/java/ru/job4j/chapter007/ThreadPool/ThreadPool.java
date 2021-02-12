package ru.job4j.chapter007.ThreadPool;

import ru.job4j.chapter007.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreadPool {

    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public ThreadPool() {
        for (int index = 0; index < size; index++) {
            threads.add(new Thread(
                    () -> {
                        tasks.poll();
                    }
            ));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void schutdown() {
        for (Thread thread:threads) {
            thread.interrupt();
        }
    }
}
