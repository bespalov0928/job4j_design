package ru.job4j.chapter007;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    private final int total = 10;

    public synchronized void offer(T value) {
        queue.add(value);
        this.notify();
    }

    public synchronized T poll() {
        T temp = null;
        if (queue.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            temp = queue.poll();
        }
        return temp;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

}
