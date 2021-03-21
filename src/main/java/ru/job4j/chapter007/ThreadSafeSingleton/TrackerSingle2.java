package ru.job4j.chapter007.ThreadSafeSingleton;

public class TrackerSingle2 {
    private static final TrackerSingle2 INSTANCE = new TrackerSingle2();

    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance(){
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
    }

}
