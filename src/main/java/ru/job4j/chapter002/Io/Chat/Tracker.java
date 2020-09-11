package ru.job4j.chapter002.Io.Chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tracker {

    public List<String> getList() {
        return list;
    }

    private List<String> list = new ArrayList<>();

    public void addString(String str) {
        list.add(str);
    }

    public void save(String file) {
        try {
            // Открыть данный файл в режиме добавления.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file, true));
            for (String str : list) {
                out.write(str + System.lineSeparator());
            }
            out.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
//        for (String str : list) {
//            try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
//                out.write(str);
//                out.append(str);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

}
