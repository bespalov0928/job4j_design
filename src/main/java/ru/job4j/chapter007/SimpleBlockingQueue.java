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
        System.out.println("offer");
        queue.add(value);
        this.notify();
        System.out.println("offer notifyAll");
    }

    public synchronized T poll() {
        System.out.println("poll");
        T temp = null;
        if (queue.size() == 0) {
            try {
                System.out.println("poll wait");
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            temp = queue.peek();
        }
        return temp;
    }
}
