package ru.job4j.chapter007;

public class SimpleBlockingQueueDemo {
    public static void main(String[] args) {
        SimpleBlockingQueue simpleBlockingQueue = new SimpleBlockingQueue<Integer>();
        Thread first = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    simpleBlockingQueue.poll();
                    System.out.println(Thread.currentThread().getName() +" : "+ Thread.currentThread().getState());
                }, "first"
        );
        Thread second = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    simpleBlockingQueue.offer(10);
                    System.out.println(Thread.currentThread().getName() +" : "+ Thread.currentThread().getState());
                }, "second"
        );


        first.start();
        second.start();
        try {
            first.join();
        } catch (InterruptedException e) {
            first.currentThread().interrupt();
        }

        try {
            second.join();
        } catch (InterruptedException e) {
            second.currentThread().interrupt();
        }

        System.out.println(simpleBlockingQueue.poll());
    }




//        System.out.println(Thread.currentThread().getName() +":" + Thread.currentThread().getState());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() +":" + Thread.currentThread().getState());


//        Thread.currentThread().interrupt();
//        int count = 0;
//        while (!Thread.currentThread().isInterrupted()) {
//            System.out.println(count++);
//        }
//        System.out.println(first.getName() +":" + first.getState());
    //Thread.currentThread().interrupt();


}
