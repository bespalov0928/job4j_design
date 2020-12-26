package ru.job4j.chapter005.lsp;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private  List<Food> list = new ArrayList<>();

    public List<Food> getList() {
        return list;
    }

    public void addList(Food food) {
        this.list.add(food);
    }

}
