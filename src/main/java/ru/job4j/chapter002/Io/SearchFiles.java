package ru.job4j.chapter002.Io;

import java.nio.file.FileVisitor;
import java.nio.file.Path;

public interface SearchFiles<Path> {

    boolean test(Path root);

}
