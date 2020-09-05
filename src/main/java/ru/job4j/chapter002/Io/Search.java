package ru.job4j.chapter002.Io;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "js").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) {
        List<Path> list;
        Searcher searcher = new Searcher(ext);
        try {
            Files.walkFileTree(root, (FileVisitor<? super Path>) searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list = searcher.getList();
        return list;

    }
}
