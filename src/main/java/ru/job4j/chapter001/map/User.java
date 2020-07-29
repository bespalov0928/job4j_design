package ru.job4j.chapter001.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

//    @Override
//    public int hashCode() {
//        return name != null ? 31 * 17 * name.hashCode() : 0;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;
        if (!this.name.equals(((User) obj).name) || !this.birthday.equals(((User) obj).birthday)) {
            return false;
        }
        return true;
    }
}
