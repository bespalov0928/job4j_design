package ru.job4j.chapter007;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASСount<T> {

    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    public void increment() {
        int current;
        int next;

        do {
            current = count.get();
            next = current + 1;
        }while (!count.compareAndSet(current, next));
    }

    public int get() {
        return count.get();
    }

    public static void main(String[] args) {
        CASСount<Integer> casСounts = new CASСount<>();
        casСounts.increment();
        int temp = casСounts.get();
        System.out.println(temp);
    }
}
