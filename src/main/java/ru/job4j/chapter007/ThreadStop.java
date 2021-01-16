package ru.job4j.chapter007;

import ru.job4j.chapter001.tree.Tree;

public class ThreadStop {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    int count = 0;
                    while (!Thread.currentThread().isInterrupted()){
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println(Thread.currentThread().getName());
                        System.out.println(count++);
                    }
                }
        );
        thread.start();
//        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
