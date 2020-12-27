package ru.job4j.chapter005.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> list = new ArrayList<>();

    @Override
    public void add(Food f) {
        list.add(f);
    }

    @Override
    public boolean accept(Food f) {
        boolean rsl = false;
        if (f.getTerm() >= 100) {
            rsl = true;
        }
        return rsl;
    }
}
