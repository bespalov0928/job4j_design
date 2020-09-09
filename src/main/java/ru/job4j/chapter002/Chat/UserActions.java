package ru.job4j.chapter002.Chat;

public interface UserActions {
    String name();

    public boolean execute(String input, Tracker tracker, String answer, boolean stop);
}
