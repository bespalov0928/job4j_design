package ru.job4j.chapter007;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getState());
                }
        );
        System.out.println(first.getName()+":"+first.getState());
        first.start();


        Thread second = new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getState());
                }
        );
        System.out.println(second.getName()+":"+second.getState());
        second.start();

        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            System.out.println(first.getName()+":"+first.getState()+"|"+second.getName()+":"+second.getState());
        }

        System.out.println(first.getName()+":"+first.getState()+"|"+second.getName()+":"+second.getState());
        System.out.println(Thread.State.TERMINATED);
    }
}
