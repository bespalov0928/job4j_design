package ru.job4j.chapter007;

public class ParallelSearch {
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        if (Thread.currentThread().isInterrupted()) {
                            System.out.println("break");
                            break;
                        }
                        System.out.println(queue.poll());
                    }
                }
        );
        consumer.start();

        Thread produser = new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                            //consumer.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    consumer.interrupt();
                }
        );
        produser.start();
    }
}
