package ru.job4j.chapter002.findFiles;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FileFisitClass extends SimpleFileVisitor<Path> {
    private List<Path> list = new ArrayList<>();
    private Predicate<Path> predicate;
    private String fileFind;

    public FileFisitClass(String fileFind, Predicate<Path> predicate) {
        this.predicate = predicate;
        this.fileFind = fileFind;
    }

    public List<Path> getList() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            list.add(file);
        }
        return CONTINUE;
    }

}
