package ru.job4j.chapter002;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        int num = 0;
        String str = "";
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }

            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                num = Integer.valueOf(line);
                if (num % 2 != 0) {
                    str = String.format("%d - %s", num, "не четное");
                } else {
                    str = String.format("%d - %s", num, "четное");
                }
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
