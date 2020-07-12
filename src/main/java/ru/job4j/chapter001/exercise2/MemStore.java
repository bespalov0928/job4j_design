package ru.job4j.chapter001.exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        int index = findObjectById(id);
        if (index >= 0) {
            mem.set(index, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        int index = findObjectById(id);
        if (index >= 0) {
            mem.remove(index);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        int index = findObjectById(id);
        if (index >= 0) {
            rsl = mem.get(index);
        }
        return rsl;
    }

    private int findObjectById(String id) {
        int rsl = -1;
        Iterator it = mem.iterator();
        int index = 0;
        while (it.hasNext()) {
            T temp = (T) it.next();
            if (temp.getId() == id) {
                //rsl = mem.get(index);
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;

    }
}
