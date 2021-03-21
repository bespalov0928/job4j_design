package ru.job4j.chapter007.ThreadSafeSingleton;

public class TrackerSingle3 {
    private static TrackerSingle3 INSTANCE;

    public TrackerSingle3() {
    }

    public static synchronized TrackerSingle3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TrackerSingle3();
        }
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
    }


}
