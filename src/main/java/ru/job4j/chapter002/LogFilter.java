package ru.job4j.chapter002;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {

    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] arr = line.split("/");
                String arrLastString = arr[arr.length - 1];
                String tmp = String.format("%s%s%s", arrLastString.charAt(5), arrLastString.charAt(6), arrLastString.charAt(7));
                if (tmp.equals("404")) {
                    //continue;
                    lines.add(line + System.lineSeparator());
                }
                //System.out.println(line);
                //lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String str: log) {
                out.write(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "log_write.txt");
    }
}
