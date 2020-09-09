package ru.job4j.chapter002.Chat;

public class Continion implements UserActions {

    @Override
    public boolean execute(String input, Tracker tracker, String answer, boolean stop) {
        //System.out.println(answer);
        return true;
    }

    @Override
    public String name() {
        return String.format("%s", "Continion");
    }
}
