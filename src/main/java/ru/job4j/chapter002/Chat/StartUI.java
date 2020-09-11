package ru.job4j.chapter002.Chat;

import javax.print.attribute.standard.MediaSize;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class StartUI {
    /**
     * @noinspection checkstyle:LocalVariableName
     */
    public void init(Input input, Tracker tracker, Map<String, UserActions> actions) {
        boolean run = true;
        String select = "Continion";
        List<String> listAnswer = readFile("chat_answer.txt");
        Boolean stop = false;
        while (run) {
            select = input.askStr();

            UserActions action = actions.get(select);
            if (action == null) {
                action = actions.get("Other");
            }
            if (action.name().equals("Continion")) {
                stop = false;
            } else if (action.name().equals("Stop")) {
                stop = true;
            }
            Random random = new Random();
            //System.out.println(stop);
            run = action.execute(select, tracker, listAnswer.get(random.nextInt(listAnswer.size() - 1)), stop);
        }
        tracker.save("chat_log.txt");
    }

    private void showMenu(Map<String, UserActions> actions) {
        System.out.println("Menu");

        for (Map.Entry<String, UserActions> cupl : actions.entrySet()) {
            //System.out.println(String.format("%s . %s", index, actions.get(index).name()));
            System.out.println(String.format("%s", cupl.getKey()));
        }
    }

    public static List<String> readFile(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(lines::add);
//            for (String line : lines) {
//                System.out.println(line);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        Map<String, UserActions> actions = new HashMap<String, UserActions>();
        actions.put("Exit", new Exit());
        actions.put("Continion", new Continion());
        actions.put("Stop", new Stop());
        actions.put("Other", new Other());
        new StartUI().init(input, tracker, actions);
    }
}
