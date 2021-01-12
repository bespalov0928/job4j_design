package ru.job4j.chapter007;

public class Wget {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                }
        );
        thread.start();
        for (int index = 0; index < 100; index++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\rLoading : " + index + "%");
        }
    }
}
