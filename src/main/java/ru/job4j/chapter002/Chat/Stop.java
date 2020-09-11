package ru.job4j.chapter002.Chat;

public class Stop implements UserActions {
    @Override
    public boolean execute(String input, Tracker tracker, String answer, boolean stop) {
        tracker.addString(String.format("%s", input));
        //tracker.save();
        //System.out.println(answer);
        return true;
    }

    @Override
    public String name() {
        return String.format("%s", "Stop");
    }
}
