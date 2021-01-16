package ru.job4j.chapter007;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ConsoleProgress implements Runnable {

    @Override
    public void run() {
        String[] process = new String[4];
        process[0] = String.valueOf("\\ ");
        process[1] = String.valueOf(" | ");
        process[2] = String.valueOf("  /");
        process[3] = String.valueOf(" | ");
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\rLoading : " + process[index]);
            index = index == 3 ? 0: index + 1;
        }
    }

    public static void main(String[] args) {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        progress.interrupt();
    }
}
