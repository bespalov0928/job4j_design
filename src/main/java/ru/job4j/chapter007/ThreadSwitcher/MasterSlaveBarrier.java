package ru.job4j.chapter007.ThreadSwitcher;

public class MasterSlaveBarrier {

    private boolean masterRun = true;
    private boolean slaveRun = false;
    private final Object monitor = this;

    public void tryMaster() {
        synchronized (monitor) {
            while (masterRun & !slaveRun) {
                try {
                    monitor.wait();
                    masterRun = false;
                    slaveRun = true;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void trySlave() {
        synchronized (monitor) {
            while (!masterRun & slaveRun) {
                try {
                    monitor.wait();
                    masterRun = true;
                    slaveRun = false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    public void doneMaster() {
        synchronized (monitor) {
            if (!masterRun & slaveRun) {
                monitor.notify();
                slaveRun = false;
                masterRun = true;
            }
        }

    }

    public void doneSlave() {
        synchronized (monitor) {
            if (masterRun & !slaveRun) {
            monitor.notify();
            slaveRun = true;
            masterRun = false;
            }
        }
    }
}
