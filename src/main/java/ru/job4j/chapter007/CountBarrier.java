package ru.job4j.chapter007;

public class CountBarrier {
    private final Object monitor = this;
    private final int total;
    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public synchronized void count() {
        monitor.notifyAll();
        count++;
    }

    public synchronized void await() {
        while (total != count) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        monitor.notifyAll();
//        //if (Integer.compare(total, count) == 0) {
//        if (total == count) {
//            monitor.notifyAll();
//        } else {
//            try {
//                monitor.wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
    }
}
