package ru.job4j.chapter004.gc;

public class User {

    //private int age;
    //private String name;

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %n", hashCode());
        //System.out.println("456");
    }

}
