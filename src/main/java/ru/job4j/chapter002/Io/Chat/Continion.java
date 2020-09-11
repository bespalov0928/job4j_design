package ru.job4j.chapter002.Io.Chat;

public class Continion implements UserActions {

    @Override
    public boolean execute(String input, Tracker tracker, String answer, boolean stop) {
        tracker.addString(String.format("%s", input));
        //System.out.println(answer);
        return true;
    }

    @Override
    public String name() {
        return String.format("%s", "Continion");
    }
}
