package ru.job4j.chapter005.lsp;

import java.util.List;

public interface Store {
    void add(Food f);

    boolean accept(Food f);

    List<Food> getList();

    void removeAllList();
}
