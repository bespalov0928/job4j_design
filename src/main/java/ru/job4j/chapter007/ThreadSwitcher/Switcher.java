package ru.job4j.chapter007.ThreadSwitcher;

public class Switcher {
    public static void main(String[] args) throws InterruptedException {
        Thread first = new Thread(
                () -> {
                    while (true) {
                        System.out.println("Thread A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    while (true) {
                        System.out.println("Thread B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        first.start();
        second.start();
        first.join();
        second.join();

        MasterSlaveBarrier.tryMaster(first);
        MasterSlaveBarrier.tryMaster(second);

        MasterSlaveBarrier.doneMaster(first);
        MasterSlaveBarrier.doneMaster(second);


    }
}
