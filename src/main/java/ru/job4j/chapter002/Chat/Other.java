package ru.job4j.chapter002.Chat;

public class Other implements UserActions {
    @Override
    public boolean execute(String input, Tracker tracker, String answer, boolean stop) {

        tracker.addString(String.format("%s/%s", input, answer));
        //tracker.save(String.format("%s/%s", input, answer), "chat_log.txt");
        if (!stop) {
            System.out.println(answer);
        }
        return true;
    }

    @Override
    public String name() {
        return String.format("%s", "Other");
    }

}
