package ru.job4j.chapter007;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Wget implements Runnable {
    private final String url;
    private final int speed;

    public Wget(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        System.out.println("1");
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, speed)) != -1) {
                System.out.println("2");
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        Thread wget = new Thread(new Wget(url, speed));
        wget.start();
        try {
            wget.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    public static void main(String[] args) {
//        Thread thread = new Thread(
//                () -> {
//                }
//        );
//        thread.start();
//        for (int index = 0; index < 100; index++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                //e.printStackTrace();
//                if (Thread.currentThread().isInterrupted()) {
//                    Thread.interrupted();
//                }
//            }
//            System.out.print("\rLoading : " + index + "%");
//        }
//    }
}
