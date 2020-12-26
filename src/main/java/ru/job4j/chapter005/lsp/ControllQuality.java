package ru.job4j.chapter005.lsp;

import java.util.List;

public class ControllQuality {
    public Zone selection(Food food, Integer disscount) {
        Zone zone = null;
        if (food.getTerm() < 25) {
            zone = new Warehouse();
            zone.addList(food);
        } else if (food.getTerm() >= 25 && food.getTerm() < 75) {
            zone = new Shop();
            zone.addList(food);
        } else if (food.getTerm() >= 75 && food.getTerm() < 100) {
            food.setDisscount(disscount);
            zone = new Shop();
            zone.addList(food);
        } else if (food.getTerm() >= 100) {
            zone = new Trash();
            zone.addList(food);
        }
        return zone;
    }
}
