package ru.job4j.chapter007.NonBlockingCache;

public class Base {
    private int id;
    private int version;
    private String name;

    public Base(int id, String name, Integer version) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersion() {
        this.version++;
    }

    public void setName(String name) {
        this.name = name;
    }
}
