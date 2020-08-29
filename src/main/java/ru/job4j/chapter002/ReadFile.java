package ru.job4j.chapter002;

import javax.print.attribute.standard.Fidelity;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line: lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        try (FileInputStream in = new FileInputStream("input.txt")) {
//            StringBuilder text = new StringBuilder();
//            int read;
//            while ((read = in.read()) != -1) {
//                text.append((char) read);
//            }
//            System.out.println(text);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
