package ru.job4j.chapter007;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.HashMap;

public class UserStorage {

    @GuardedBy("user")
    private HashMap<Integer, User> users = new HashMap<>();

    public synchronized boolean add(User user) {
//        boolean rsl = true;
//        if (users.putIfAbsent(user.getId(), user) != null) {
//            rsl = false;
//        }
//        try {
//            users.put(user.getId(), user);
//        } catch (Exception e) {
//            rsl = false;
//            e.printStackTrace();
//        }
        return users.putIfAbsent(user.getId(), user) != null ? false : true;
    }

    public synchronized boolean update(User user) {
//        boolean rsl = true;
//        if (users.replace(user.getId(), user) == null) {
//            rsl = false;
//        }
//        User userTmp = users.get(user.getId());
//        if (userTmp == null) {
//            rsl = false;
//        } else {
//            userTmp.setAmount(user.getAmount());
//        }
        return users.replace(user.getId(), user) == null ? false : true;

    }

    public synchronized boolean delete(User user) {
//        boolean rsl = false;
//        User userTmp = users.remove(user.getId());
//        if (userTmp == null) {
//            rsl = false;
//        }
        return users.remove(user.getId(), user);
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean rsl = true;
        User userfrom = users.get(fromId);
        User userTo = users.get(toId);
        if (userfrom.getAmount() < amount) {
            return false;
        }

        if (userfrom != null && userTo != null) {
            userTo.setAmount(userTo.getAmount());
            userfrom.setAmount(userfrom.getAmount() - amount);
        } else {
            rsl = false;
        }
        return rsl;
    }

}
