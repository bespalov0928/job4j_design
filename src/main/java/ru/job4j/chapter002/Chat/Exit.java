package ru.job4j.chapter002.Chat;

public class Exit implements UserActions {
    @Override
    public boolean execute(String input, Tracker tracker, String answer, boolean stop) {
        //System.out.println(answer);
        return false;
    }

    @Override
    public String name() {
        return String.format("%s", "Exit");
    }
}
