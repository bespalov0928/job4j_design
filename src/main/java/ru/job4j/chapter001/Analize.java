package ru.job4j.chapter001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * возвращает статистику об изменении коллекции
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.id, user.name);
        }
        for (User user : current) {
            String nameTmp = map.get(user.id);
            if (nameTmp == null || !nameTmp.equals(user.name)) {
                continue;
            }
            map.remove(user.id);
        }
        int changed = map.size();
        int added = current.size() - previous.size();
        int delete = previous.size() - current.size();

        Info info = new Info();
        info.added = added > 0 ? added : 0;
        info.changed = changed;
        info.delete = delete > 0 ? delete : 0;

        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            int rsl = 17;
            rsl = rsl * 31 * id;
            //rsl = rsl * 31 * name.hashCode();

            return rsl;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            User user = (User) obj;
            if (this.id != user.id || this.name != user.name) {
                return false;
            }
            return true;
        }
    }

    public static class Info {
        int added;
        int changed;
        int delete;


        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Info info = (Info) obj;
            if (this.added != info.added || this.changed != info.changed || this.delete != info.delete) {
                return false;
            }
            return true;
        }
    }

}
