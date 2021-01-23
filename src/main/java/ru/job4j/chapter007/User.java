package ru.job4j.chapter007;

import net.jcip.annotations.Immutable;

@Immutable
public class User {
    private int id;
    private String name;
    private int amount;

    public User() {
    }

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public static User of(String name) {
        User user = new User();
        user.name = name;
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
