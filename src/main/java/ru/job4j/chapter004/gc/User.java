package ru.job4j.chapter004.gc;
import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;
public class User {

    //private int age;
    //private String name;

    @Override
    protected void finalize() throws Throwable {
        //System.out.printf("Removed %d %n", sizeOf(this));
        System.out.printf("Removed %d %n", hashCode());
    }

}
