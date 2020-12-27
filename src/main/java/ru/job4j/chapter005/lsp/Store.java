package ru.job4j.chapter005.lsp;

public interface Store {
    void add(Food f);

    boolean accept(Food f);
}
