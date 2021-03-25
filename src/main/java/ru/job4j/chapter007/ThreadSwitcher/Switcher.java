package ru.job4j.chapter007.ThreadSwitcher;

public class Switcher {
    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier barrier = new MasterSlaveBarrier();
        Thread master = new Thread(
                () -> {
                    while (true) {
                        System.out.println("Thread A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        barrier.tryMaster();
                        barrier.doneSlave();
                    }
                }
        );

        Thread slave = new Thread(
                () -> {
                    while (true) {
                        System.out.println("Thread B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        barrier.trySlave();
                        barrier.doneMaster();
                    }
                }
        );

        master.start();
        slave.start();

        master.join();
        slave.join();
    }
}
