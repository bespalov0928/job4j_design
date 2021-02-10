package ru.job4j.chapter007.NonBlockingCache;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    public void add(Base model) throws OptimisticException {
        Base temp = map.get(model.getId());
        if (temp != null) {
            new OptimisticException("Throw Exception in Thread");
        }
        map.put(model.getId(), model);
    }

    public void update(Base model) throws OptimisticException {

        int key = model.getId();
        Base modelNew = map.computeIfPresent(key, (k, v) -> {
                    System.out.println(Thread.currentThread().getName() + " : " + v.getVersion() + " : " + model.getVersion());
                    while (v.getVersion() == model.getVersion()) {
                        v.setName(model.getName());
                        v.setVersion();
                    }
                    System.out.println("Throw Exception in Thread");
                    new OptimisticException("Throw Exception in Thread");
                    return v;
                }
        );
    }

    public void delete(Base model) throws OptimisticException {
        Base temp = map.remove(model.getId());
        if (temp == null) {
            new OptimisticException("Throw Exception in Thread");
        }
    }

    public Base get(Integer key) {
        return map.get(key);
    }
}
