package ru.job4j.chapter007.ThreadSafeSingleton;

public class TrackerSingle5 {
    public TrackerSingle5() {
    }

    public static TrackerSingle5 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model){
        return model;
    }

    public static final class Holder {
        private static final TrackerSingle5 INSTANCE = new TrackerSingle5();
    }

    public static void main(String[] args) {
        TrackerSingle5 tracker = TrackerSingle5.getInstance();
    }
}
