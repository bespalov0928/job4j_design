package ru.job4j.chapter007;

import net.jcip.annotations.Immutable;

@Immutable
public class User {
    private int id;
    private String name;
    private int amount;
    private String email;

    public User() {
    }

    public User(int id, int amount, String email) {
        this.id = id;
        this.amount = amount;
        this.email = email;
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

    public String getEmail() {
        return email;
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

    @Override
    public String toString() {
        return String.format("%s%s%s", id, name, email);
    }
}
