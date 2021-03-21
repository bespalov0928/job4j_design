package ru.job4j.chapter007.ThreadSafeSingleton;

public enum TrackerSingle1 {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle1 tracker = TrackerSingle1.INSTANCE;
    }
}
