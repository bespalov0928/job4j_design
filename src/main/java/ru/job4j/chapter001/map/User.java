package ru.job4j.chapter001.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;
    //private int hashCode;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

//    public int getHashCode() {
//        return hashCode;
//    }

    @Override
    public int hashCode() {
//        int rsl = hashCode;
//        if (hashCode == 0) {
            int rsl = 17;
            rsl = rsl * 31 * name.hashCode();
            rsl = rsl * 31 * birthday.hashCode();
//        }
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
        if (!this.name.equals(((User) obj).name) || !this.birthday.equals(((User) obj).birthday)) {
            return false;
        }
        return true;
    }
}
