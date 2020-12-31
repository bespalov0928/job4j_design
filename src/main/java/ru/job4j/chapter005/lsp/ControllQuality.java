package ru.job4j.chapter005.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Store> list = new ArrayList<>();

    public ControllQuality(List<Store> list) {
        this.list = list;
    }

    public void selection(Food f) {
        for (Store store : list) {
            if (store.accept(f)){
                store.add(f);
            }
        }
    }

    public void resort(List<Store> listStore) {
        List<Food> listFood = new ArrayList<Food>();
        for (Store store: list) {
            listFood.addAll(listFood.size(), store.getList());
        }

        list.clear();
        list.addAll(listStore);

        for (Food food: listFood) {
            for (Store store : list) {
                if (store.accept(food)){
                    store.add(food);
                    break;
                }
            }
        }
    }
}
