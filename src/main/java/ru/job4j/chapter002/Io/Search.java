package ru.job4j.chapter002.Io;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("No root path specified.");
        } else if (args.length == 1) {
            throw new IllegalArgumentException("File extension not specified.");
        }
        String firstParam = args[0];
        String ext = args[1];

        Path start = Paths.get(firstParam);
        search(start, ext, (Predicate<Path>) p -> p.toFile().getName().endsWith(ext)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext, Predicate<Path> predicate) {
        List<Path> list;
        //Searcher searcher = new Searcher(ext, new SearchFiles<Path>(p -> p.toFile().getName().endsWith(ext)));
        Searcher searcher = new Searcher(ext, predicate);
        try {
            Files.walkFileTree(root, (FileVisitor<? super Path>) searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list = searcher.getList();
        return list;

    }
}
