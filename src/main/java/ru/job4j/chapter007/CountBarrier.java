package ru.job4j.chapter007;

public class CountBarrier {
    private final Object monitor = this;
    private final int total;
    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public synchronized void count() {
        count++;
    }

    public synchronized void await() {
        if (Integer.compare(total, count) == 0) {
            monitor.notifyAll();
        }else{
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
