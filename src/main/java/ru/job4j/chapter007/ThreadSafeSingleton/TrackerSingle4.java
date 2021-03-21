package ru.job4j.chapter007.ThreadSafeSingleton;

public class TrackerSingle4 {
    private static volatile TrackerSingle4 INSTANCE;

    public TrackerSingle4() {
    }

    public static TrackerSingle4 getInstance() {
        if (INSTANCE == null) {
            synchronized (TrackerSingle4.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TrackerSingle4();
                }
            }

        }
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle4 tracker = TrackerSingle4.getInstance();
    }
}
