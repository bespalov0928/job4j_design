package ru.job4j.chapter002;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class Abuse {
    public static void drop(String sourch, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(sourch));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(out::print);
        }
    }
}
