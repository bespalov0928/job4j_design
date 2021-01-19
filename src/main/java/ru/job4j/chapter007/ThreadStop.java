package ru.job4j.chapter007;

import ru.job4j.chapter001.tree.Tree;

public class ThreadStop {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    System.out.println("1");
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            System.out.println("start ...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            System.out.println(Thread.currentThread().isInterrupted());
                            System.out.println(Thread.currentThread().getState());
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (
                InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
