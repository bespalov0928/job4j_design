package ru.job4j.chapter001;

import java.util.List;

/**
 * возвращает статистику об изменении коллекции
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        int added = current.size() - previous.size();
        int changed = 0;
        for (User user: previous) {
            int index = current.indexOf(user);
            if (index == -1) {
                continue;
            }
            User tmpUser = current.get(index);
            if (tmpUser.id == user.id && !tmpUser.name.equals(user.name)) {
                changed++;
            }
        }
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
            if (this.id != user.id) {
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
