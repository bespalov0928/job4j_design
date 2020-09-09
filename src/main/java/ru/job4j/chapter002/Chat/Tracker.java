package ru.job4j.chapter002.Chat;

import java.io.*;

public class Tracker {

    //процедура записи в лог
    public void save(String str, String file) {
        try {
            // Открыть данный файл в режиме добавления.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file, true));
            out.write(str + System.lineSeparator());
            out.close();
        } catch (IOException e) {

            System.out.println("exception occoured" + e);
        }
//        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
//            out.write(str);
//            out.append(str);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
