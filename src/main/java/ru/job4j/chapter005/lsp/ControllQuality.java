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
//    public Zone selection(Food food, Integer disscount) {
//        Zone zone = null;
//        if (food.getTerm() < 25) {
//            zone = new Warehouse();
//            zone.addList(food);
//        } else if (food.getTerm() >= 25 && food.getTerm() < 75) {
//            zone = new Shop();
//            zone.addList(food);
//        } else if (food.getTerm() >= 75 && food.getTerm() < 100) {
//            food.setDisscount(disscount);
//            zone = new Shop();
//            zone.addList(food);
//        } else if (food.getTerm() >= 100) {
//            zone = new Trash();
//            zone.addList(food);
//        }
//        return zone;
//    }
}
