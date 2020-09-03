package ru.job4j.chapter002;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) {
        List<String> lines = new ArrayList<>();
        lines = readFile(source);
        writeFile(target, lines);
    }

    private List<String> readFile(String source) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            Boolean start = false;
            String line;
            while ((line = in.readLine()) != null) {
                String[] arr = line.split(" ");
                String arrLastString = arr[arr.length - 1];
                String strTmp = arr[0];
                if ((strTmp.equals("400") || strTmp.equals("500")) && !start) {
                    lines.add(line + ";");
                    start = true;
                } else if ((strTmp.equals("200") || strTmp.equals("300")) && start) {
                    lines.add(line + System.lineSeparator());
                    start = false;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private void writeFile(String target, List<String> lines) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String str : lines) {
                out.write(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Analizy analize = new Analizy();
        analize.unavailable("server.log", "serverAanalize.log");
    }
}
