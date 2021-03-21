package ru.job4j.chapter007.ThreadSwitcher;

public class MasterSlaveBarrier {
    public static void tryMaster(Object master) {
        try {
            master.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void trySlave(Object slave) {
        try {
            slave.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void doneMaster(Object master) {
        master.notify();
    }

    public static void doneSlave(Object slave) {
        slave.notify();
    }
}
