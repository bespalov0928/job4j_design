package ru.job4j.chapter002.Io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Searcher implements FileVisitor<Path> {

    private List<Path> list = new ArrayList<>();
    private String ext;
    private Predicate<Path> predicate;


    public void setExt(String ext) {
        this.ext = ext;
    }

    public Searcher(String ext, Predicate<Path> predicate) {
        this.ext = ext;
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (predicate.test(file)) {
            list.add(file);
        }
//        SearchFiles<Path> seacher = new SearchFiles<Path>(p -> p.toFile​().getName.endsWith(ext))
//        SearchFiles<Path> seacher = new SearchFiles<Path>() {
//            @Override
//            public boolean test(Path root) {
//                return root.toFile().getName().endsWith(ext);
//            }
//        };
//        if (!seacher.test(file)) {
//            list.add(file);
//        }
//        System.out.println(file.toAbsolutePath());
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public List<Path> getList() {
        return list;
    }
}
