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
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            double startTime = System.currentTimeMillis();
            int index = 1;
            while ((bytesRead = in.read(dataBuffer, 0, speed)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                double endTime = System.currentTimeMillis();
                double delta = (endTime - startTime) / index;
                if (delta < 1.0) {
                    System.out.println(delta);
                    try {
                        Thread.sleep((long) (1.0 - delta));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                System.out.println("Total execution time/index: " + (endTime-startTime)/index + "ms");
//                System.out.println("Total execution time: " + (endTime-startTime) + "ms");
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml";//args[0];
        int speed = 3;//Integer.parseInt(args[1]);
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
